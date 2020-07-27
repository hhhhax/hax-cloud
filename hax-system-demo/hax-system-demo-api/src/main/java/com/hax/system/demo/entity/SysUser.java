package com.hax.system.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * <p>
 * 管理员用户表
 * </p>
 *
 * @author hax
 * @since 2020-07-23
 */
@Data
@ApiModel(value="SysUser对象", description="管理员用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "管理员ID")
    private Integer id;

    @ApiModelProperty(value = "真实名字")
    private String name;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "部门id")
    private Integer deptId;

    @ApiModelProperty(value = "登陆账号")
    private String username;

    @ApiModelProperty(value = "加密后的密码")
    private String password;

    @ApiModelProperty(value = "密码的盐")
    private String passwordSalt;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    private String delFlag;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AVATAR = "avatar";

    public static final String DEPT_ID = "dept_id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String PASSWORD_SALT = "password_salt";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DEL_FLAG = "del_flag";



}
