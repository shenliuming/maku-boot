package net.maku.member.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.maku.framework.common.utils.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Auther: Sterling Shen
 * @Date: 2025/7/18 17:33
 * @Description:
 */
@Data
@Schema(description = "会员Token")
public class MemberTokenVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "access_token")
    @JsonProperty(value = "access_token")
    private String accessToken;

    @Schema(description = "access_token 过期时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime accessTokenExpire;

    @Schema(description = "会员ID")
    @JsonProperty(value = "memberId")
    private Long memberId;
}
