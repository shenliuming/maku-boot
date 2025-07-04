package net.maku.yoga.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.yoga.convert.YogaBookingConvert;
import net.maku.yoga.entity.YogaBookingEntity;
import net.maku.yoga.query.YogaBookingQuery;
import net.maku.yoga.vo.YogaBookingVO;
import net.maku.yoga.dao.YogaBookingDao;
import net.maku.yoga.service.YogaBookingService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.yoga.vo.YogaBookingExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * 
 */
@Service
@AllArgsConstructor
public class YogaBookingServiceImpl extends BaseServiceImpl<YogaBookingDao, YogaBookingEntity> implements YogaBookingService {
    private final TransService transService;

    @Override
    public PageResult<YogaBookingVO> page(YogaBookingQuery query) {
        IPage<YogaBookingEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(YogaBookingConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<YogaBookingEntity> getWrapper(YogaBookingQuery query){
        LambdaQueryWrapper<YogaBookingEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public YogaBookingVO get(Long id) {
        YogaBookingEntity entity = baseMapper.selectById(id);
        YogaBookingVO vo = YogaBookingConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(YogaBookingVO vo) {
        YogaBookingEntity entity = YogaBookingConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(YogaBookingVO vo) {
        YogaBookingEntity entity = YogaBookingConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



    @Override
    public void export() {
    List<YogaBookingExcelVO> excelList = YogaBookingConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(YogaBookingExcelVO.class, "预约记录表", null, excelList);
    }

}