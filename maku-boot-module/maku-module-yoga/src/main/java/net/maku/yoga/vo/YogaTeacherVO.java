package net.maku.yoga.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Data
@Schema(description = "老师表")
public class YogaTeacherVO {
	@Schema(description = "老师ID")
	private Long id;

	@Schema(description = "姓名")
	private String name;

	@Schema(description = "手机号")
	private String phone;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "关联会员ID")
	private Long memberId;

	@Schema(description = "状态 0:离职 1:在职")
	private Integer status;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

}