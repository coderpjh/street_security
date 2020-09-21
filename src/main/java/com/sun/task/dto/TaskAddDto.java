package com.sun.task.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 任务周期
     */
    @ApiModelProperty(value = "任务周期")
    private String taskDate;

    /**
     * 任务紧急程度：1-紧急，2-正常， 3-可搁置
     */
    @ApiModelProperty(value = "任务紧急程度：1-紧急，2-正常， 3-可搁置")
    private Integer taskUrgencyLevel;

    /**
     * 任务负责人
     */
    @ApiModelProperty(value = "任务负责人")
    private String taskResponsible;

    /**
     * 任务审核人
     */
    @ApiModelProperty(value = "任务审核人")
    private String taskVerify;

    /**
     * 审核状态:0-未审核， 1-已审核
     */
    @ApiModelProperty(value = "审核状态:0-未审核， 1-已审核")
    private Integer taskStatus;

    /**
     * 审核结果
     */
    @ApiModelProperty(value = "审核结果")
    private String verifyResult;

}
