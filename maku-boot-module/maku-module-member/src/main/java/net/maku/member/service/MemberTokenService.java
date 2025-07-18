package net.maku.member.service;

import net.maku.member.vo.MemberTokenVO;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 20:00
 * @Description:
 */
public interface MemberTokenService {

    MemberTokenVO createToken(Long memberId);

}
