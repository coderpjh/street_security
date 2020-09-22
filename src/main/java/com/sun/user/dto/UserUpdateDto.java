package com.sun.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserUpdateDto对象", description = "用户更新对象")
public class UserUpdateDto {

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 用户旧密码
     */
    @ApiModelProperty(value = "用户旧密码")
    private String oldPwd;

    /**
     * 用户新密码
     */
    @ApiModelProperty(value = "用户新密码")
    private String newPwd;

}
