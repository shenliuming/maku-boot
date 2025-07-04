package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */

@Data
@TableName("yoga_teacher")
public class YogaTeacherEntity {
	/**
	* 老师ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 姓名
	*/
	@TableField(value = "name")
	private String name;

	/**
	* 手机号
	*/
	@TableField(value = "phone")
	private String phone;

	/**
	* 头像
	*/
	@TableField(value = "avatar")
	private String avatar;

	/**
	* 关联会员ID
	*/
	@TableField(value = "member_id")
	private Long memberId;

	/**
	* 状态 0:离职 1:在职
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}