package com.sun.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TaskVerifyDto对象", description = "任务信息审核对象")
public class TaskVerifyDto {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

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
