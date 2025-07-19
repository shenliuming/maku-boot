package net.maku.yoga.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("yoga_banner")
public class YogaBannerEntity {
	/**
	* 老师ID
	*/
	@TableId
	@TableField(value = "id")
	private Long id;

	/**
	* 图片标题
	*/
	@TableField(value = "title")
	private String title;

	/**
	* 图片URL
	*/
	@TableField(value = "image_url")
	private String imageUrl;

	/**
	* 排序值（越大越靠前）
	*/
	@TableField(value = "sort")
	private Integer sort;

	/**
	* 状态 0:停用 1:启用
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 点击跳转链接
	*/
	@TableField(value = "click_link")
	private String clickLink;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

}