package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaCourseVO;
import net.maku.yoga.query.YogaCourseQuery;
import net.maku.yoga.entity.YogaCourseEntity;
import java.util.List;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
public interface YogaCourseService extends BaseService<YogaCourseEntity> {

    PageResult<YogaCourseVO> page(YogaCourseQuery query);

    YogaCourseVO get(Long id);


    void save(YogaCourseVO vo);

    void update(YogaCourseVO vo);

    void delete(List<Long> idList);


    void export();
}