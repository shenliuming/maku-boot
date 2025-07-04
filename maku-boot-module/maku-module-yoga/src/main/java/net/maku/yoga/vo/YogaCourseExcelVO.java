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
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@ColumnWidth(20)
public class YogaCourseExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("课程名称")
	private String name;

	@ExcelProperty("1-私教 2-小班 3-团课 4-精品课")
	private Integer type;

	@ExcelProperty("时长(分钟)")
	private Integer duration;

	@ExcelProperty("状态 0:禁用 1:启用")
	private Integer status;

}