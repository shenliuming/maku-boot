package net.maku.yoga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.yoga.service.YogaSpaceService;
import net.maku.yoga.query.YogaSpaceQuery;
import net.maku.yoga.vo.YogaSpaceVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 场地表
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@RestController
@RequestMapping("/yoga/space")
@Tag(name="场地表")
@AllArgsConstructor
public class YogaSpaceController {
    private final YogaSpaceService yogaSpaceService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('yoga:space')")
    public Result<PageResult<YogaSpaceVO>> page(@ParameterObject @Valid YogaSpaceQuery query){
        PageResult<YogaSpaceVO> page = yogaSpaceService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('yoga:space')")
    public Result<YogaSpaceVO> get(@PathVariable("id") Long id){
        YogaSpaceVO data = yogaSpaceService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('yoga:space')")
    public Result<String> save(@RequestBody YogaSpaceVO vo){
        yogaSpaceService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('yoga:space')")
    public Result<String> update(@RequestBody @Valid YogaSpaceVO vo){
        yogaSpaceService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('yoga:space')")
    public Result<String> delete(@RequestBody List<Long> idList){
        yogaSpaceService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('yoga:space')")
    public void export() {
        yogaSpaceService.export();
    }
}