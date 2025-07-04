package net.maku.yoga.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.yoga.entity.YogaBookingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaBookingDao extends BaseDao<YogaBookingEntity> {

}