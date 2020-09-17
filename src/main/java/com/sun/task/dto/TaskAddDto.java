package com.sun.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TaskAddDto对象", description = "任务信息新增对象")
public class TaskAddDto {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称")
    private String taskName;

    /**
     * 任务类型:1-常规任务， 2-专项任务， 3-通用任务， 4-特性任务
     */
    @ApiModelProperty(value = "任务类型:1-常规任务， 2-专项任务， 3-通用任务， 4-特性任务")
    private Integer taskType;

    /**
     * 任务部门
     */
    @ApiModelProperty(value = "任务部门")
    private String taskDepartment;

    /**
     * 任务描述
     */
    @ApiModelProperty(value = "任务描述")
    private String taskDescription;

}
