package com.sun.professor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

}
