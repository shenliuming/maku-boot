package net.maku.yoga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.yoga.service.YogaScheduleService;
import net.maku.yoga.query.YogaScheduleQuery;
import net.maku.yoga.vo.YogaScheduleVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 课程排期表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@RestController
@RequestMapping("/yoga/schedule")
@Tag(name="课程排期表")
@AllArgsConstructor
public class YogaScheduleController {
    private final YogaScheduleService yogaScheduleService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public Result<PageResult<YogaScheduleVO>> page(@ParameterObject @Valid YogaScheduleQuery query){
        PageResult<YogaScheduleVO> page = yogaScheduleService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public Result<YogaScheduleVO> get(@PathVariable("id") Long id){
        YogaScheduleVO data = yogaScheduleService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public Result<String> save(@RequestBody YogaScheduleVO vo){
        yogaScheduleService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public Result<String> update(@RequestBody @Valid YogaScheduleVO vo){
        yogaScheduleService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public Result<String> delete(@RequestBody List<Long> idList){
        yogaScheduleService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('yoga:schedule')")
    public void export() {
        yogaScheduleService.export();
    }
}