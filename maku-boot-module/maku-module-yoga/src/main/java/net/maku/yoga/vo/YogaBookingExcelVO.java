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
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@ColumnWidth(20)
public class YogaBookingExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("会员ID")
	private Long memberId;

	@ExcelProperty("排期ID")
	private Long scheduleId;

	@ExcelProperty("1-预约中 2-已完成 3-已取消")
	private Integer status;

}