package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Data
@Schema(description = "课程表")
public class YogaCourseVO {
	@Schema(description = "课程ID")
	private Long id;

	@Schema(description = "课程名称")
	private String name;

	@Schema(description = "1-私教 2-小班 3-团课 4-精品课")
	private Integer type;

	@Schema(description = "时长(分钟)")
	private Integer duration;

	@Schema(description = "状态 0:禁用 1:启用")
	private Integer status;

	@Schema(description = "版本号")
	private Integer version;

	@Schema(description = "删除标识 0:正常 1:已删除")
	private Integer deleted;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

}