package net.maku.member.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.maku.framework.common.exception.ServerException;
import net.maku.member.cache.MemberTokenStoreCache;
import net.maku.member.vo.MemberDetail;
import net.maku.member.vo.MemberUserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 20:51
 * @Description:
 */
@Component
public class MemberTokenInterceptor implements HandlerInterceptor {
    private final MemberTokenStoreCache memberTokenCache;

    public MemberTokenInterceptor(MemberTokenStoreCache memberTokenCache) {
        this.memberTokenCache = memberTokenCache;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token) || !token.startsWith("Bearer ")) {
            throw new ServerException("无效的Token格式");
        }

        token = token.substring(7);
        MemberDetail member = memberTokenCache.getMember(token);
        if (member == null) {
            throw new ServerException("Token已失效");
        }

        request.setAttribute("token", token);
        return true;
    }
}
