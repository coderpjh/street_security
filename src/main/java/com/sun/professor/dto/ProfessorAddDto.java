package com.sun.professor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProfessorAddDto对象", description = "专家信息新增对象")
public class ProfessorAddDto {

    /**
     *主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     *专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    private String professorName;

    /**
     *性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     *出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date data;

    /**
     *家庭住址
     */
    @ApiModelProperty(value = "家庭住址")
    private String address;

    /**
     *联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String telephone;

    /**
     *所属领域
     */
    @ApiModelProperty(value = "所属领域")
    private String field;

    /**
     *所属专业
     */
    @ApiModelProperty(value = "所属专业")
    private String professional;

    /**
     *相关经验
     */
    @ApiModelProperty(value = "相关经验")
    private String relatedExperience;

    /**
     *资质政府
     */
    @ApiModelProperty(value = "资质政府")
    private String qualificationGovernment;

    /**
     *所获奖项
     */
    @ApiModelProperty(value = "所获奖项")
    private String awards;


}
