package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaScheduleVO;
import net.maku.yoga.query.YogaScheduleQuery;
import net.maku.yoga.entity.YogaScheduleEntity;
import java.util.List;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
public interface YogaScheduleService extends BaseService<YogaScheduleEntity> {

    PageResult<YogaScheduleVO> page(YogaScheduleQuery query);

    YogaScheduleVO get(Long id);


    void save(YogaScheduleVO vo);

    void update(YogaScheduleVO vo);

    void delete(List<Long> idList);


    void export();
}