package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaBannerVO;
import net.maku.yoga.query.YogaBannerQuery;
import net.maku.yoga.entity.YogaBannerEntity;
import java.util.List;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface YogaBannerService extends BaseService<YogaBannerEntity> {

    PageResult<YogaBannerVO> page(YogaBannerQuery query);

    YogaBannerVO get(Long id);

    void save(YogaBannerVO vo);

    void update(YogaBannerVO vo);

    void delete(List<Long> idList);


}