package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@Schema(description = "场地表")
public class YogaSpaceVO {
	@Schema(description = "场地ID")
	private Long id;

	@Schema(description = "场地名称")
	private String name;

	@Schema(description = "容纳人数")
	private Integer capacity;

	@Schema(description = "状态 0:关闭 1:开放")
	private Integer status;

}