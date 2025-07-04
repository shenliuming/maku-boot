package net.maku.yoga.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.yoga.entity.YogaScheduleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Mapper
public interface YogaScheduleDao extends BaseDao<YogaScheduleEntity> {

}