package net.maku.yoga.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.yoga.entity.YogaBannerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface YogaBannerDao extends BaseDao<YogaBannerEntity> {

}