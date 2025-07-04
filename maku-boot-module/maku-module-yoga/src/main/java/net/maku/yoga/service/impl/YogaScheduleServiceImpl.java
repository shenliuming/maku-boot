package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaScheduleConvert;
import net.maku.yoga.entity.YogaScheduleEntity;
import net.maku.yoga.query.YogaScheduleQuery;
import net.maku.yoga.vo.YogaScheduleVO;
import net.maku.yoga.dao.YogaScheduleDao;
import net.maku.yoga.service.YogaScheduleService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.yoga.vo.YogaScheduleExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Service
@AllArgsConstructor
public class YogaScheduleServiceImpl extends BaseServiceImpl<YogaScheduleDao, YogaScheduleEntity> implements YogaScheduleService {
    private final TransService transService;

    @Override
    public PageResult<YogaScheduleVO> page(YogaScheduleQuery query) {
        IPage<YogaScheduleEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaScheduleConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaScheduleEntity> getWrapper(YogaScheduleQuery query){
        LambdaQueryWrapper<YogaScheduleEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaScheduleVO get(Long id) {
        YogaScheduleEntity entity = baseMapper.selectById(id);
        YogaScheduleVO vo = YogaScheduleConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaScheduleVO vo) {
        YogaScheduleEntity entity = YogaScheduleConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaScheduleVO vo) {
        YogaScheduleEntity entity = YogaScheduleConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



    @Override
    public void export() {
    List<YogaScheduleExcelVO> excelList = YogaScheduleConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(YogaScheduleExcelVO.class, "课程排期表", null, excelList);
    }

}