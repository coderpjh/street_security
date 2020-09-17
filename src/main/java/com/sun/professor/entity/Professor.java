package com.sun.professor.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
@ApiModel(value="Professor对象", description="专家信息表")
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    private String professorName;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date data;

    /**
     * 家庭住址
     */
    @ApiModelProperty(value = "家庭住址")
    private String address;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String telephone;

    /**
     * 所属领域
     */
    @ApiModelProperty(value = "所属领域")
    private String field;

    /**
     * 所属专业
     */
    @ApiModelProperty(value = "所属专业")
    private String professional;

    /**
     * 相关经验
     */
    @ApiModelProperty(value = "相关经验")
    private String relatedExperience;

    /**
     * 资质政府
     */
    @ApiModelProperty(value = "资质政府")
    private String qualificationGovernment;

    /**
     * 所获奖项
     */
    @ApiModelProperty(value = "所获奖项")
    private String awards;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer deleted;
}
