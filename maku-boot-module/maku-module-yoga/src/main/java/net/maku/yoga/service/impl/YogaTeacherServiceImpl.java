package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaTeacherConvert;
import net.maku.yoga.entity.YogaTeacherEntity;
import net.maku.yoga.query.YogaTeacherQuery;
import net.maku.yoga.vo.YogaTeacherVO;
import net.maku.yoga.dao.YogaTeacherDao;
import net.maku.yoga.service.YogaTeacherService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.yoga.vo.YogaTeacherExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 老师表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Service
@AllArgsConstructor
public class YogaTeacherServiceImpl extends BaseServiceImpl<YogaTeacherDao, YogaTeacherEntity> implements YogaTeacherService {
    private final TransService transService;

    @Override
    public PageResult<YogaTeacherVO> page(YogaTeacherQuery query) {
        IPage<YogaTeacherEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaTeacherConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaTeacherEntity> getWrapper(YogaTeacherQuery query){
        LambdaQueryWrapper<YogaTeacherEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaTeacherVO get(Long id) {
        YogaTeacherEntity entity = baseMapper.selectById(id);
        YogaTeacherVO vo = YogaTeacherConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaTeacherVO vo) {
        YogaTeacherEntity entity = YogaTeacherConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaTeacherVO vo) {
        YogaTeacherEntity entity = YogaTeacherConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



    @Override
    public void export() {
    List<YogaTeacherExcelVO> excelList = YogaTeacherConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(YogaTeacherExcelVO.class, "老师表", null, excelList);
    }

}