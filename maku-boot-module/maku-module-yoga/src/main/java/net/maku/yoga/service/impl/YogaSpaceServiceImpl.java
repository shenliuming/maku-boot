package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaSpaceConvert;
import net.maku.yoga.entity.YogaSpaceEntity;
import net.maku.yoga.query.YogaSpaceQuery;
import net.maku.yoga.vo.YogaSpaceVO;
import net.maku.yoga.dao.YogaSpaceDao;
import net.maku.yoga.service.YogaSpaceService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.yoga.vo.YogaSpaceExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Service
@AllArgsConstructor
public class YogaSpaceServiceImpl extends BaseServiceImpl<YogaSpaceDao, YogaSpaceEntity> implements YogaSpaceService {
    private final TransService transService;

    @Override
    public PageResult<YogaSpaceVO> page(YogaSpaceQuery query) {
        IPage<YogaSpaceEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaSpaceConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaSpaceEntity> getWrapper(YogaSpaceQuery query){
        LambdaQueryWrapper<YogaSpaceEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaSpaceVO get(Long id) {
        YogaSpaceEntity entity = baseMapper.selectById(id);
        YogaSpaceVO vo = YogaSpaceConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaSpaceVO vo) {
        YogaSpaceEntity entity = YogaSpaceConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaSpaceVO vo) {
        YogaSpaceEntity entity = YogaSpaceConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



    @Override
    public void export() {
    List<YogaSpaceExcelVO> excelList = YogaSpaceConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(YogaSpaceExcelVO.class, "场地表", null, excelList);
    }

}