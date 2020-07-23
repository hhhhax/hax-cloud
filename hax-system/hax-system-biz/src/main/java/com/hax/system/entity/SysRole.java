package com.hax.system.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * 角色ID
     */
    @Id
    private Integer id;

    /**
     * 角色姓名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取角色ID
     *
     * @return id - 角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色姓名
     *
     * @return role_name - 角色姓名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色姓名
     *
     * @param roleName 角色姓名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色描述
     *
     * @return role_desc - 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置角色描述
     *
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
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