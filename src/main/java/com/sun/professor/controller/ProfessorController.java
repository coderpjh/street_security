package com.sun.professor.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sun.professor.dto.ProfessorAddDto;
import com.sun.professor.entity.Professor;
import com.sun.professor.service.ProfessorService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sunql
 * @since 2020-09-11
 */
@RestController
@AllArgsConstructor
@RequestMapping("/professor/professor")
public class ProfessorController {

    private final ProfessorService professorService;


    /**
     * 添加专家信息
     *
     * @param professorAddDto 专家信息新增对象
     * @return 返回操作结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加专家信息", notes = "添加专家信息")
    public R<String> add(@RequestBody @Validated ProfessorAddDto professorAddDto) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorAddDto, professor);
        professorService.save(professor);
        return R.ok("用户信息添加成功");
    }

    /*
     * 更新专家信息
     *
     * @param professorAddDto 专家信息修改对象
     * @return 返回操作结果
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新专家信息", notes = "更新专家信息")
    public R<Long> update(@RequestBody @Validated ProfessorAddDto professorAddDto) {
        Professor professor = professorService.getById(professorAddDto.getId());
        BeanUtils.copyProperties(professorAddDto, professor);
        professorService.updateById(professor);
        return R.ok(professor.getId());
    }

    /**
     * 删除专家信息
     *
     * @param id 专家ID
     * @return 返回操作结果
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除专家信息", notes = "删除专家信息")
    public R<Boolean> delete(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return R.failed("专家信息不存在");
        }
        professorService.removeById(id);
        return R.ok(Boolean.TRUE);
    }


    /**
     * 专家信息查询
     *
     * @return 返回操作结果
     */
    @GetMapping("/list")
    @ApiOperation(value = "获取专家信息", notes = "获取专家信息")
    public R<List<Professor>> list(){
        LambdaQueryWrapper<Professor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Professor::getCreateTime);
        List<Professor> list = professorService.list(queryWrapper);
        return R.ok(list);
    }
}

