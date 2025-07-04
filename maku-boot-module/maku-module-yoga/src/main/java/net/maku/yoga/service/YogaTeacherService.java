package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaTeacherVO;
import net.maku.yoga.query.YogaTeacherQuery;
import net.maku.yoga.entity.YogaTeacherEntity;
import java.util.List;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
public interface YogaTeacherService extends BaseService<YogaTeacherEntity> {

    PageResult<YogaTeacherVO> page(YogaTeacherQuery query);

    YogaTeacherVO get(Long id);


    void save(YogaTeacherVO vo);

    void update(YogaTeacherVO vo);

    void delete(List<Long> idList);


    void export();
}