package com.sun.risk.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sunql
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("risk")
@ApiModel(value="Risk对象", description="风险信息对象")
public class Risk implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 风险名称
     */
    @ApiModelProperty(value = "风险名称")
    private String riskName;

    /**
     * 所属区域
     */
    @ApiModelProperty(value = "所属区域")
    private String riskScope;

    /**
     * 风险等级
     */
    @ApiModelProperty(value = "风险等级")
    private Integer riskLevel;

    /**
     * 风险类型
     */
    @ApiModelProperty(value = "风险类型")
    private String riskType;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String latitude;

    /**
     * 风险上报人
     */
    @ApiModelProperty(value = "风险上报人")
    private String reportName;

    /**
     * 风险负责人
     */
    @ApiModelProperty(value = "风险负责人")
    private String responsibleName;

    /**
     * 风险描述
     */
    @ApiModelProperty(value = "风险描述")
    private String riskDescription;

    /**
     *创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     *更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     *是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer deleted;
}
