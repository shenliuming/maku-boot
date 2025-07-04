package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */

@Data
@TableName("yoga_space")
public class YogaSpaceEntity {
	/**
	* 场地ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 场地名称
	*/
	@TableField(value = "name")
	private String name;

	/**
	* 容纳人数
	*/
	@TableField(value = "capacity")
	private Integer capacity;

	/**
	* 状态 0:关闭 1:开放
	*/
	@TableField(value = "status")
	private Integer status;

}