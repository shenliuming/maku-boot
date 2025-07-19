package net.maku.yoga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.yoga.service.YogaBannerService;
import net.maku.yoga.query.YogaBannerQuery;
import net.maku.yoga.vo.YogaBannerVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 首页banner管理
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/yoga/banner")
@Tag(name="首页banner管理")
@AllArgsConstructor
public class YogaBannerController {
    private final YogaBannerService yogaBannerService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('yoga:banner')")
    public Result<PageResult<YogaBannerVO>> page(@ParameterObject @Valid YogaBannerQuery query){
        PageResult<YogaBannerVO> page = yogaBannerService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('yoga:banner')")
    public Result<YogaBannerVO> get(@PathVariable("id") Long id){
        YogaBannerVO data = yogaBannerService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('yoga:banner')")
    public Result<String> save(@RequestBody YogaBannerVO vo){
        yogaBannerService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('yoga:banner')")
    public Result<String> update(@RequestBody @Valid YogaBannerVO vo){
        yogaBannerService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('yoga:banner')")
    public Result<String> delete(@RequestBody List<Long> idList){
        yogaBannerService.delete(idList);

        return Result.ok();
    }


}