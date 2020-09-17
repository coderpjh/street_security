package com.sun.task.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sun.task.dto.TaskAddDto;
import com.sun.task.entity.Task;
import com.sun.task.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 任务信息表 前端控制器
 * </p>
 *
 * @author sunql
 * @since 2020-09-17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/task/task")
public class TaskController {

    private final TaskService taskService;

    /**
     * 添加任务信息
     *
     * @param taskAddDto 任务信息添加对象
     * @return 返回操作结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加任务信息", notes = "添加任务信息")
    public R<Long> add(@RequestBody @Validated TaskAddDto taskAddDto) {
        Task task = new Task();
        BeanUtils.copyProperties(taskAddDto, task);
        taskService.save(task);
        return R.ok(taskAddDto.getId());
    }

    /**
     * 更新任务信息
     *
     * @param taskAddDto 任务信息更新对象
     * @return 返回操作结果
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新任务信息", notes = "添加更新信息")
    public R<Long> update(@RequestBody @Validated TaskAddDto taskAddDto) {
        if (taskAddDto.getId() == null) {
            return R.failed("任务信息不能为空");
        }
        Task task = taskService.getById(taskAddDto.getId());
        BeanUtils.copyProperties(taskAddDto, task);
        taskService.updateById(task);
        return R.ok(task.getId());
    }

    /**
     * 删除任务信息
     *
     * @param id 任务ID
     * @return
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除任务信息", notes = "删除任务信息")
    public R<Boolean> delete(@PathVariable Long id) {
        taskService.removeById(id);
        return R.ok(Boolean.TRUE);
    }

    /**
     * 查询任务列表
     *
     * @param type 任务类型
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "任务信息列表", notes = "任务信息列表")
    public R<List<Task>> list(Integer type) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        if (type != null) {
            queryWrapper.eq(Task::getTaskType, type);
        }
        queryWrapper.orderByDesc(Task::getCreateTime);
        List<Task> list = taskService.list(queryWrapper);
        return R.ok(list);
    }

}

