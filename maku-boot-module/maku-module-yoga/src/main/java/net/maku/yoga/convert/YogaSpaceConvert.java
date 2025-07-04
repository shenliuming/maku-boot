package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaSpaceEntity;
import net.maku.yoga.vo.YogaSpaceVO;
import net.maku.yoga.vo.YogaSpaceExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaSpaceConvert {
    YogaSpaceConvert INSTANCE = Mappers.getMapper(YogaSpaceConvert.class);

    YogaSpaceEntity convert(YogaSpaceVO vo);

    YogaSpaceVO convert(YogaSpaceEntity entity);

    List<YogaSpaceVO> convertList(List<YogaSpaceEntity> list);

    List<YogaSpaceEntity> convertList2(List<YogaSpaceVO> list);

    List<YogaSpaceExcelVO> convertExcelList(List<YogaSpaceEntity> list);

    List<YogaSpaceEntity> convertExcelList2(List<YogaSpaceExcelVO> list);
}