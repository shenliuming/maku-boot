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
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@ColumnWidth(20)
public class YogaScheduleExcelVO implements TransPojo {
	@ExcelIgnore
	private Long id;

	@ExcelProperty("课程ID")
	private Long courseId;

	@ExcelProperty("老师ID")
	private Long teacherId;

	@ExcelProperty("场地ID")
	private Long spaceId;

	@ExcelProperty(value = "开始时间", converter = LocalDateTimeConverter.class)
	private LocalDateTime startTime;

	@ExcelProperty(value = "结束时间", converter = LocalDateTimeConverter.class)
	private LocalDateTime endTime;

	@ExcelProperty("最大名额")
	private Integer maxSeats;

	@ExcelProperty("已预约数")
	private Integer bookedSeats;

	@ExcelProperty("1-可预约 2-已满 3-取消")
	private Integer status;

}