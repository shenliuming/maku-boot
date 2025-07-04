package net.maku.yoga.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.yoga.entity.YogaTeacherEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Mapper
public interface YogaTeacherDao extends BaseDao<YogaTeacherEntity> {

}