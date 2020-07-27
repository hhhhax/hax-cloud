package com.hax.system.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ApiModel("管理员创建 DTO")
@Data
//chain的中文含义是链式的，设置为true，则setter方法返回当前对象
@Accessors(chain = true)
public class SystemUserVo {

    private String id;
    private String name;

    private String username;

    private String password;

}
