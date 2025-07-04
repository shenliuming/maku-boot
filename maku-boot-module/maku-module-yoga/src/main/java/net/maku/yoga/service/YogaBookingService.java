package net.maku.yoga.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.yoga.vo.YogaBookingVO;
import net.maku.yoga.query.YogaBookingQuery;
import net.maku.yoga.entity.YogaBookingEntity;
import java.util.List;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
public interface YogaBookingService extends BaseService<YogaBookingEntity> {

    PageResult<YogaBookingVO> page(YogaBookingQuery query);

    YogaBookingVO get(Long id);


    void save(YogaBookingVO vo);

    void update(YogaBookingVO vo);

    void delete(List<Long> idList);


    void export();
}