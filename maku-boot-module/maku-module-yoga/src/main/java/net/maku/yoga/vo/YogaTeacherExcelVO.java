package net.maku.yoga.vo;

import lombok.Data;
import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.annotation.write.style.ColumnWidth;
import com.fhs.core.trans.vo.TransPojo;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import net.maku.framework.common.excel.LocalDateTimeConverter;
import java.time.LocalDateTime;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Data
@ColumnWidth(20)
public class YogaTeacherExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("姓名")
	private String name;

	@ExcelProperty("手机号")
	private String phone;

	@ExcelProperty("头像")
	private String avatar;

	@ExcelProperty("关联会员ID")
	private Long memberId;

	@ExcelProperty("状态 0:离职 1:在职")
	private Integer status;

}