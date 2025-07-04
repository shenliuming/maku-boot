package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@Schema(description = "课程排期表")
public class YogaScheduleVO {
	@Schema(description = "排期ID")
	private Long id;

	@Schema(description = "课程ID")
	private Long courseId;

	@Schema(description = "老师ID")
	private Long teacherId;

	@Schema(description = "场地ID")
	private Long spaceId;

	@Schema(description = "开始时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime startTime;

	@Schema(description = "结束时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime endTime;

	@Schema(description = "最大名额")
	private Integer maxSeats;

	@Schema(description = "已预约数")
	private Integer bookedSeats;

	@Schema(description = "1-可预约 2-已满 3-取消")
	private Integer status;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

}