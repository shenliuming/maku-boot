package net.maku.yoga.convert;

import net.maku.yoga.entity.YogaBannerEntity;
import net.maku.yoga.vo.YogaBannerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface YogaBannerConvert {
    YogaBannerConvert INSTANCE = Mappers.getMapper(YogaBannerConvert.class);

    YogaBannerEntity convert(YogaBannerVO vo);

    YogaBannerVO convert(YogaBannerEntity entity);

    List<YogaBannerVO> convertList(List<YogaBannerEntity> list);

    List<YogaBannerEntity> convertList2(List<YogaBannerVO> list);

}