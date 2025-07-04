package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */

@Data
@TableName("yoga_course")
public class YogaCourseEntity {
	/**
	* 课程ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 课程名称
	*/
	@TableField(value = "name")
	private String name;

	/**
	* 1-私教 2-小班 3-团课 4-精品课
	*/
	@TableField(value = "type")
	private Integer type;

	/**
	* 时长(分钟)
	*/
	@TableField(value = "duration")
	private Integer duration;

	/**
	* 状态 0:禁用 1:启用
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 版本号
	*/
	@Version
	@TableField(value = "version", fill = FieldFill.INSERT)
	private Integer version;

	/**
	* 删除标识 0:正常 1:已删除
	*/
	@TableLogic
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}