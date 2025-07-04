package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */

@Data
@TableName("yoga_booking")
public class YogaBookingEntity {
	/**
	* 预约ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 会员ID
	*/
	@TableField(value = "member_id")
	private Long memberId;

	/**
	* 排期ID
	*/
	@TableField(value = "schedule_id")
	private Long scheduleId;

	/**
	* 1-预约中 2-已完成 3-已取消
	*/
	@TableField(value = "status")
	private Integer status;

	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}