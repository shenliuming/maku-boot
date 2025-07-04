package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaSpaceVO;
import net.maku.yoga.query.YogaSpaceQuery;
import net.maku.yoga.entity.YogaSpaceEntity;
import java.util.List;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
public interface YogaSpaceService extends BaseService<YogaSpaceEntity> {

    PageResult<YogaSpaceVO> page(YogaSpaceQuery query);

    YogaSpaceVO get(Long id);


    void save(YogaSpaceVO vo);

    void update(YogaSpaceVO vo);

    void delete(List<Long> idList);


    void export();
}