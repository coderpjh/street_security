package com.sun.risk.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sun.risk.dto.RiskAddDto;
import com.sun.risk.entity.Risk;
import com.sun.risk.service.RiskService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2020-09-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/risk/risk")
public class RiskController {

    private final RiskService riskService;

    /**
     * 风险上报信息新增
     *
     * @param riskAddDto 风险上报新增信息对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加风险信息", notes = "添加风险信息")
    public R<String> add(@Validated @RequestBody RiskAddDto riskAddDto){
        Risk risk = new Risk();
        BeanUtils.copyProperties(riskAddDto, risk);
        riskService.save(risk);
        return R.ok("风险上报成功");
    }

    /**
     * 风险信息查询
     *
     * @return 返回操作结果
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取风险信息", notes = "获取风险信息")
    public R<List<Risk>> list(){
        LambdaQueryWrapper<Risk> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Risk::getCreateTime);
        List<Risk> list = riskService.list(queryWrapper);
        return R.ok(list);
    }
}

