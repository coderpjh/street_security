package com.sun.task.service.impl;

import com.sun.task.entity.Task;
import com.sun.task.mapper.TaskMapper;
import com.sun.task.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务信息表 服务实现类
 * </p>
 *
 * @author sunql
 * @since 2020-09-17
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
