package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "首页banner管理")
public class YogaBannerVO {
	@Schema(description = "老师ID")
	private Long id;

	@Schema(description = "图片标题")
	private String title;

	@Schema(description = "图片描述")
	private String description;

	@Schema(description = "图片URL")
	private String imageUrl;

	@Schema(description = "排序值（越大越靠前）")
	private Integer sort;

	@Schema(description = "状态 0:停用 1:启用")
	private Integer status;

	@Schema(description = "点击跳转链接")
	private String clickLink;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

}