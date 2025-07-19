package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaBannerConvert;
import net.maku.yoga.entity.YogaBannerEntity;
import net.maku.yoga.query.YogaBannerQuery;
import net.maku.yoga.vo.YogaBannerVO;
import net.maku.yoga.dao.YogaBannerDao;
import net.maku.yoga.service.YogaBannerService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class YogaBannerServiceImpl extends BaseServiceImpl<YogaBannerDao, YogaBannerEntity> implements YogaBannerService {

    @Override
    public PageResult<YogaBannerVO> page(YogaBannerQuery query) {
        IPage<YogaBannerEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaBannerConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaBannerEntity> getWrapper(YogaBannerQuery query){
        LambdaQueryWrapper<YogaBannerEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaBannerVO get(Long id) {
        YogaBannerEntity entity = baseMapper.selectById(id);
        YogaBannerVO vo = YogaBannerConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaBannerVO vo) {
        YogaBannerEntity entity = YogaBannerConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaBannerVO vo) {
        YogaBannerEntity entity = YogaBannerConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }




}