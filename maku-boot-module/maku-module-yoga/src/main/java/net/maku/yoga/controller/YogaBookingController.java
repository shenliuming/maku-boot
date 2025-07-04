package net.maku.yoga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.yoga.service.YogaBookingService;
import net.maku.yoga.query.YogaBookingQuery;
import net.maku.yoga.vo.YogaBookingVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 预约记录表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@RestController
@RequestMapping("/yoga/booking")
@Tag(name="预约记录表")
@AllArgsConstructor
public class YogaBookingController {
    private final YogaBookingService yogaBookingService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('yoga:booking')")
    public Result<PageResult<YogaBookingVO>> page(@ParameterObject @Valid YogaBookingQuery query){
        PageResult<YogaBookingVO> page = yogaBookingService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('yoga:booking')")
    public Result<YogaBookingVO> get(@PathVariable("id") Long id){
        YogaBookingVO data = yogaBookingService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('yoga:booking')")
    public Result<String> save(@RequestBody YogaBookingVO vo){
        yogaBookingService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('yoga:booking')")
    public Result<String> update(@RequestBody @Valid YogaBookingVO vo){
        yogaBookingService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('yoga:booking')")
    public Result<String> delete(@RequestBody List<Long> idList){
        yogaBookingService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('yoga:booking')")
    public void export() {
        yogaBookingService.export();
    }
}