package net.maku.framework.common.cache;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 20:33
 * @Description:
 */
public class MemberRedisKeys {

    public static String getAccessTokenKey(String accessToken) {
        return "member:token:" + accessToken;
    }
}
