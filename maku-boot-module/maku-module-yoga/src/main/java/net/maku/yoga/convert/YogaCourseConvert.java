package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaCourseEntity;
import net.maku.yoga.vo.YogaCourseVO;
import net.maku.yoga.vo.YogaCourseExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaCourseConvert {
    YogaCourseConvert INSTANCE = Mappers.getMapper(YogaCourseConvert.class);

    YogaCourseEntity convert(YogaCourseVO vo);

    YogaCourseVO convert(YogaCourseEntity entity);

    List<YogaCourseVO> convertList(List<YogaCourseEntity> list);

    List<YogaCourseEntity> convertList2(List<YogaCourseVO> list);

    List<YogaCourseExcelVO> convertExcelList(List<YogaCourseEntity> list);

    List<YogaCourseEntity> convertExcelList2(List<YogaCourseExcelVO> list);
}