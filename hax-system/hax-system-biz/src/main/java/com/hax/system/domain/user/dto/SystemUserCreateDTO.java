package com.hax.system.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel("管理员创建 DTO")
@Data
@Accessors(chain = true)
public class SystemUserCreateDTO {

    @ApiModelProperty(value = "真实名字", required = true, example = "小陈")
    @NotEmpty(message = "真实名字不能为空")
    @Length(max = 10, message = "真实名字长度最大为 10 位")
    private String name;

    @ApiModelProperty(value = "登陆账号", required = true, example = "15601691300")
    @NotEmpty(message = "登陆账号不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "buzhidao")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

}
