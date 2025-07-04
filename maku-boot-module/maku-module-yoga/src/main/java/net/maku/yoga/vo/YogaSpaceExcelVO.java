package net.maku.yoga.vo;

import lombok.Data;
import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.annotation.write.style.ColumnWidth;
import com.fhs.core.trans.vo.TransPojo;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import net.maku.framework.common.excel.LocalDateTimeConverter;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@ColumnWidth(20)
public class YogaSpaceExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("场地名称")
	private String name;

	@ExcelProperty("容纳人数")
	private Integer capacity;

	@ExcelProperty("状态 0:关闭 1:开放")
	private Integer status;

}