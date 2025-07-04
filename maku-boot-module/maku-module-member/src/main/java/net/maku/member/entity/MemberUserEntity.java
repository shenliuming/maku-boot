package net.maku.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 会员管理
 *
 * @author 阿沐 babamu@126.com
 */

@Data
@TableName("member_user")
public class MemberUserEntity {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     *  微信OpenID
     */
    private String wechatOpenid;

    /**
     * 微信UnionID
     */
    private String wechatUnionid;

    /**
     * 微信昵称
     */
    private String wechatNickname;

    /**
     * 微信头像
     */
    private String wechatAvatar;

    /**
     * 微信备注
     */
    private String wechatRemark;

    /**
     * 微信绑定时间
     */
    private LocalDateTime wechatBindTime;

    /**
     * 关注：1关注, 0未关注
     */
    private Integer wechatSubscribe;

    /**
     * 电话区号
     */
    private String region;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 删除标识
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}