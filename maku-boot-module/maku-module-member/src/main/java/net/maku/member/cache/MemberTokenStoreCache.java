package net.maku.member.cache;

import cn.hutool.core.collection.ListUtil;
import lombok.AllArgsConstructor;
import net.maku.framework.common.cache.MemberRedisKeys;
import net.maku.framework.common.cache.RedisCache;
import net.maku.framework.common.cache.RedisKeys;
import net.maku.framework.security.user.UserDetail;
import net.maku.member.vo.MemberDetail;
import net.maku.member.vo.MemberUserVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 20:26
 * @Description:
 */
@Component
@AllArgsConstructor
public class MemberTokenStoreCache {

    private final RedisCache redisCache;

    public void saveMember(String accessToken, MemberDetail user) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);
        // 默认2小时
        redisCache.set(key, user, 60 * 60 * 32);
    }

    public void saveMember(String accessToken, MemberDetail user, long expire) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user, expire);
    }

    public void updateMember(String accessToken, MemberDetail user) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);
        Long expire = redisCache.getExpire(key);
        redisCache.set(key, user, expire);
    }

    public Long getExpire(String accessToken) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);

        return redisCache.getExpire(key);
    }

    public MemberDetail getMember(String accessToken) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);
        return (MemberDetail) redisCache.get(key);
    }

    public void deleteMember(String accessToken) {
        String key = MemberRedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }

    public List<String> getMemberKeyList() {
        String pattern = MemberRedisKeys.getAccessTokenKey("*");
        Set<String> sets = redisCache.keys(pattern);

        return ListUtil.toList(sets);
    }
}
