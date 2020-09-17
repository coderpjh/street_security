package com.sun.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务信息表
 * </p>
 *
 * @author sunql
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("task")
@ApiModel(value="Task对象", description="任务信息表")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer deleted;
}
