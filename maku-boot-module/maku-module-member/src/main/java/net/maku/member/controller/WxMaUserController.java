package net.maku.member.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.util.WxMaConfigHolder;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import net.maku.member.cache.MemberTokenStoreCache;
import net.maku.member.convert.MemberUserConvert;
import net.maku.member.entity.MemberUserEntity;
import net.maku.member.service.MemberTokenService;
import net.maku.member.service.MemberUserService;
import net.maku.member.utils.JsonUtils;
import net.maku.member.vo.MemberDetail;
import net.maku.member.vo.MemberTokenVO;
import net.maku.member.vo.MemberUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/wx/user/{appid}")
public class WxMaUserController {
    private final WxMaService wxMaService;
    private final MemberUserService memberUserService;
    private final MemberTokenService memberTokenService;
    private final MemberTokenStoreCache tokenStoreCache;

    /**
     * 小程序用户登录接口
     */
    @GetMapping("/login")
    public String login(@PathVariable String appid, String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            String openid = session.getOpenid();

            // 查询或创建会员
            MemberUserEntity memberUser = memberUserService.getByOpenid(openid);
            if (memberUser == null) {
                memberUser = new MemberUserEntity();
                memberUser.setWechatOpenid(openid);
                memberUser.setCreateTime(LocalDateTime.now());
                memberUser.setStatus(1);
                memberUser.setNickName(openid);
                memberUser.setMobile(openid);
                memberUser.setWechatBindTime(LocalDateTime.now());
                memberUserService.save(memberUser);
            }
            // 更新登录信息
//            memberUser.setLastLoginIp(IpUtils.getIpAddress());
            memberUser.setLastLoginTime(LocalDateTime.now());
            memberUserService.updateById(memberUser);
            MemberTokenVO tokenVO = memberTokenService.createToken(memberUser.getId());

            MemberDetail memberDetail = MemberUserConvert.INSTANCE.convertMemberDetail(memberUser);
            memberDetail.setSessionKey(session.getSessionKey());
            tokenStoreCache.saveMember(tokenVO.getAccessToken(), memberDetail);

            return JSONObject.toJSONString(tokenVO);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return e.toString();
        } finally {
            WxMaConfigHolder.remove();//清理ThreadLocal
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(@PathVariable String appid, String sessionKey,
                       String signature, String rawData, String encryptedData, String iv) {
        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        // 用户信息校验
        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            WxMaConfigHolder.remove();//清理ThreadLocal
            return "user check failed";
        }

        // 解密用户信息
        WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        WxMaConfigHolder.remove();//清理ThreadLocal
        return JsonUtils.toJson(userInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public String phone(@PathVariable String appid, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        // 用户信息校验
        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            WxMaConfigHolder.remove();//清理ThreadLocal
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        WxMaConfigHolder.remove();//清理ThreadLocal
        return JsonUtils.toJson(phoneNoInfo);
    }

    /**
     * 微信手机号授权登录接口
     * 说明：需先通过wx.login获取临时code，再通过getPhoneNumber事件获取encryptedData和iv
     */
    @PostMapping("/phoneLogin")
    public String phoneLogin(@PathVariable String appid,
                             @RequestBody JSONObject requestBody) {

        String code = requestBody.getString("code");
        String encryptedData = requestBody.getString("encryptedData");
        String iv = requestBody.getString("iv");

        // 1. 参数校验
        if (StringUtils.isAnyBlank(code, encryptedData, iv)) {
            return "参数缺失：code/encryptedData/iv 不能为空";
        }

        // 2. 切换微信小程序配置
        if (!wxMaService.switchover(appid)) {
            log.error("无效的appid配置: {}", appid);
            throw new IllegalArgumentException("无效的小程序配置");
        }

        try {
            // 3. 获取session信息
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            String sessionKey = session.getSessionKey();
            String openid = session.getOpenid();
            log.info("手机号登录获取session: openid={}", openid);

            // 4. 解密手机号
            WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
            String phone = phoneNoInfo.getPhoneNumber();
            log.info("解密手机号成功: {}", phone);

            // 5. 查询或创建会员
            MemberUserEntity memberUser = memberUserService.getByOpenid(openid);
            boolean isNewUser = false;

            if (memberUser == null) {
                memberUser = new MemberUserEntity();
                memberUser.setWechatOpenid(openid);
                memberUser.setMobile(phone);
                memberUser.setNickName("微信用户_" + phone.substring(7));  // 尾号昵称
                memberUser.setCreateTime(LocalDateTime.now());
                memberUser.setStatus(1);
                memberUser.setWechatBindTime(LocalDateTime.now());
                memberUser.setLastLoginTime(LocalDateTime.now());
                memberUserService.save(memberUser);
                isNewUser = true;
                log.info("创建新会员: id={}", memberUser.getId());
            } else {
                // 更新手机号及绑定时间
                memberUser.setMobile(phone);
                memberUser.setWechatBindTime(LocalDateTime.now());
                memberUser.setLastLoginTime(LocalDateTime.now());
                memberUserService.updateById(memberUser);
                log.info("更新会员手机号: id={}", memberUser.getId());
            }

            // 6. 生成访问令牌
            MemberTokenVO tokenVO = memberTokenService.createToken(memberUser.getId());

            // 7. 缓存会员信息（包含sessionKey用于后续解密）
            MemberDetail memberDetail = MemberUserConvert.INSTANCE.convertMemberDetail(memberUser);
            memberDetail.setSessionKey(sessionKey);  // 关键：缓存会话密钥
            tokenStoreCache.saveMember(tokenVO.getAccessToken(), memberDetail);
            log.info("生成访问令牌: token={}", tokenVO.getAccessToken());

            // 8. 返回结果（包含新用户标识）
            JSONObject result = (JSONObject) JSONObject.toJSON(tokenVO);
            result.put("isNewUser", isNewUser);
            return result.toJSONString();

        } catch (WxErrorException e) {
            log.error("微信接口错误: errcode={} msg={}", e.getError().getErrorCode(), e.getError().getErrorMsg(), e);
            return "微信服务异常: " + e.getError().getErrorMsg();
        } finally {
            WxMaConfigHolder.remove();  // 清理ThreadLocal
        }
    }
}
