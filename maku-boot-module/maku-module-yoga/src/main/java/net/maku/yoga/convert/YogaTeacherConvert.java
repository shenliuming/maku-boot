package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaTeacherEntity;
import net.maku.yoga.vo.YogaTeacherVO;
import net.maku.yoga.vo.YogaTeacherExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaTeacherConvert {
    YogaTeacherConvert INSTANCE = Mappers.getMapper(YogaTeacherConvert.class);

    YogaTeacherEntity convert(YogaTeacherVO vo);

    YogaTeacherVO convert(YogaTeacherEntity entity);

    List<YogaTeacherVO> convertList(List<YogaTeacherEntity> list);

    List<YogaTeacherEntity> convertList2(List<YogaTeacherVO> list);

    List<YogaTeacherExcelVO> convertExcelList(List<YogaTeacherEntity> list);

    List<YogaTeacherEntity> convertExcelList2(List<YogaTeacherExcelVO> list);
}