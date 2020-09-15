package com.sun.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserAddDto对象", description = "用户信息新增对象")
public class UserAddDto {

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;


    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 权限等级
     */
    @ApiModelProperty(value = "权限等级")
    private Integer level;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String telephone;
}
