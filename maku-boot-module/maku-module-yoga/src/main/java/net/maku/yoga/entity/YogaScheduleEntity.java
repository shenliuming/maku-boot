package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */

@Data
@TableName("yoga_schedule")
public class YogaScheduleEntity {
	/**
	* 排期ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 课程ID
	*/
	@TableField(value = "course_id")
	private Long courseId;

	/**
	* 老师ID
	*/
	@TableField(value = "teacher_id")
	private Long teacherId;

	/**
	* 场地ID
	*/
	@TableField(value = "space_id")
	private Long spaceId;

	/**
	* 开始时间
	*/
	@TableField(value = "start_time")
	private LocalDateTime startTime;

	/**
	* 结束时间
	*/
	@TableField(value = "end_time")
	private LocalDateTime endTime;

	/**
	* 最大名额
	*/
	@TableField(value = "max_seats")
	private Integer maxSeats;

	/**
	* 已预约数
	*/
	@TableField(value = "booked_seats")
	private Integer bookedSeats;

	/**
	* 1-可预约 2-已满 3-取消
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}