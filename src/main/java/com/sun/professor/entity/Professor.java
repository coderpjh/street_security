package com.sun.professor.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 专家信息表
 * </p>
 *
 * @author sunql
 * @since 2020-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("professor")
@ApiModel(value="Professor对象", description="专家信息对象")
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "专家姓名")
    private String professorName;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date data;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "联系方式")
    private String telephone;

    @ApiModelProperty(value = "所属领域")
    private String field;

    @ApiModelProperty(value = "所属专业")
    private String professional;

    @ApiModelProperty(value = "相关经验")
    private String relatedExperience;

    @ApiModelProperty(value = "资质政府")
    private String qualificationGovernment;

    @ApiModelProperty(value = "所获奖项")
    private String awards;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer deleted;
}
