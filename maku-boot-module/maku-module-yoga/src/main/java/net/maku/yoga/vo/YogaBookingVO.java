package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@Schema(description = "预约记录表")
public class YogaBookingVO {
	@Schema(description = "预约ID")
	private Long id;

	@Schema(description = "会员ID")
	private Long memberId;

	@Schema(description = "排期ID")
	private Long scheduleId;

	@Schema(description = "1-预约中 2-已完成 3-已取消")
	private Integer status;

	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

}