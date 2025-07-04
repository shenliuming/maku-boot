package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaCourseConvert;
import net.maku.yoga.entity.YogaCourseEntity;
import net.maku.yoga.query.YogaCourseQuery;
import net.maku.yoga.vo.YogaCourseVO;
import net.maku.yoga.dao.YogaCourseDao;
import net.maku.yoga.service.YogaCourseService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.yoga.vo.YogaCourseExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Service
@AllArgsConstructor
public class YogaCourseServiceImpl extends BaseServiceImpl<YogaCourseDao, YogaCourseEntity> implements YogaCourseService {
    private final TransService transService;

    @Override
    public PageResult<YogaCourseVO> page(YogaCourseQuery query) {
        IPage<YogaCourseEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaCourseConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaCourseEntity> getWrapper(YogaCourseQuery query){
        LambdaQueryWrapper<YogaCourseEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaCourseVO get(Long id) {
        YogaCourseEntity entity = baseMapper.selectById(id);
        YogaCourseVO vo = YogaCourseConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaCourseVO vo) {
        YogaCourseEntity entity = YogaCourseConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaCourseVO vo) {
        YogaCourseEntity entity = YogaCourseConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



    @Override
    public void export() {
    List<YogaCourseExcelVO> excelList = YogaCourseConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(YogaCourseExcelVO.class, "课程表", null, excelList);
    }

}