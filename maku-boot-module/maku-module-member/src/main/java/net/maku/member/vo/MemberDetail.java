package net.maku.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 22:05
 * @Description:
 */
@Data
public class MemberDetail {

    private Long id;
    private String nickName;
    private String mobile;
    private String wechatOpenid;
    private String wechatUnionid;
    private String wechatNickname;
    private String wechatAvatar;
    private String wechatRemark;
    private String sessionKey;

}
