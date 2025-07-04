package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaBookingEntity;
import net.maku.yoga.vo.YogaBookingVO;
import net.maku.yoga.vo.YogaBookingExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Mapper
public interface YogaBookingConvert {
    YogaBookingConvert INSTANCE = Mappers.getMapper(YogaBookingConvert.class);

    YogaBookingEntity convert(YogaBookingVO vo);

    YogaBookingVO convert(YogaBookingEntity entity);

    List<YogaBookingVO> convertList(List<YogaBookingEntity> list);

    List<YogaBookingEntity> convertList2(List<YogaBookingVO> list);

    List<YogaBookingExcelVO> convertExcelList(List<YogaBookingEntity> list);

    List<YogaBookingEntity> convertExcelList2(List<YogaBookingExcelVO> list);
}