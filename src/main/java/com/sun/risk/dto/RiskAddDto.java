package com.sun.risk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RiskAddDto对象", description = "风险信息新增对象")
public class RiskAddDto {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
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
}
