package net.maku.yoga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.yoga.service.YogaCourseService;
import net.maku.yoga.query.YogaCourseQuery;
import net.maku.yoga.vo.YogaCourseVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 课程表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@RestController
@RequestMapping("/yoga/course")
@Tag(name="课程表")
@AllArgsConstructor
public class YogaCourseController {
    private final YogaCourseService yogaCourseService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('yoga:course')")
    public Result<PageResult<YogaCourseVO>> page(@ParameterObject @Valid YogaCourseQuery query){
        PageResult<YogaCourseVO> page = yogaCourseService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('yoga:course')")
    public Result<YogaCourseVO> get(@PathVariable("id") Long id){
        YogaCourseVO data = yogaCourseService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('yoga:course')")
    public Result<String> save(@RequestBody YogaCourseVO vo){
        yogaCourseService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('yoga:course')")
    public Result<String> update(@RequestBody @Valid YogaCourseVO vo){
        yogaCourseService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('yoga:course')")
    public Result<String> delete(@RequestBody List<Long> idList){
        yogaCourseService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('yoga:course')")
    public void export() {
        yogaCourseService.export();
    }
}