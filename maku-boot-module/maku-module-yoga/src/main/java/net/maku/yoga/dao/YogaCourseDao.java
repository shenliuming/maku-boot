package net.maku.yoga.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.yoga.entity.YogaCourseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaCourseDao extends BaseDao<YogaCourseEntity> {

}