package net.maku.member.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import net.maku.framework.security.utils.TokenUtils;
import net.maku.member.service.MemberTokenService;
import net.maku.member.vo.MemberTokenVO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 20:00
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MemberTokenServiceImpl  implements MemberTokenService {
    @Override
    public MemberTokenVO createToken(Long memberId) {
        // 生成token
        String accessToken = TokenUtils.generator();

        MemberTokenVO tokenVO = new MemberTokenVO();

        // 过期时间
        Date now = new Date();
        tokenVO.setAccessTokenExpire(DateUtil.toLocalDateTime(DateUtil.offsetHour(now, 8)));
        tokenVO.setAccessToken(accessToken);
        tokenVO.setMemberId(memberId);

        return tokenVO;
    }
}
