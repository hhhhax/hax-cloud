package com.hax.system.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 管理员ID
     */
    @Id
    private Integer id;

    /**
     * 真实名字
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 密码的盐
     */
    @Column(name = "password_salt")
    private String passwordSalt;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取管理员ID
     *
     * @return id - 管理员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员ID
     *
     * @param id 管理员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取真实名字
     *
     * @return name - 真实名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实名字
     *
     * @param name 真实名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取登陆账号
     *
     * @return username - 登陆账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登陆账号
     *
     * @param username 登陆账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取加密后的密码
     *
     * @return password - 加密后的密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置加密后的密码
     *
     * @param password 加密后的密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码的盐
     *
     * @return password_salt - 密码的盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置密码的盐
     *
     * @param passwordSalt 密码的盐
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后更新时间
     *
     * @return update_time - 最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标识（0-正常,1-删除）
     *
     * @return del_flag - 删除标识（0-正常,1-删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标识（0-正常,1-删除）
     *
     * @param delFlag 删除标识（0-正常,1-删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}