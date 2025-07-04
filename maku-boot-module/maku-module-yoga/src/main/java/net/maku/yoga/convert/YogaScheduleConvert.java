package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaScheduleEntity;
import net.maku.yoga.vo.YogaScheduleVO;
import net.maku.yoga.vo.YogaScheduleExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaScheduleConvert {
    YogaScheduleConvert INSTANCE = Mappers.getMapper(YogaScheduleConvert.class);

    YogaScheduleEntity convert(YogaScheduleVO vo);

    YogaScheduleVO convert(YogaScheduleEntity entity);

    List<YogaScheduleVO> convertList(List<YogaScheduleEntity> list);

    List<YogaScheduleEntity> convertList2(List<YogaScheduleVO> list);

    List<YogaScheduleExcelVO> convertExcelList(List<YogaScheduleEntity> list);

    List<YogaScheduleEntity> convertExcelList2(List<YogaScheduleExcelVO> list);
}