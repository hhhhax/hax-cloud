package com.hax.system.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    /**
     * 菜单ID
     */
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 0-开启，1- 关闭
     */
    @Column(name = "keep_alive")
    private String keepAlive;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除标记(0--正常 1--删除)
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取菜单ID
     *
     * @return id - 菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单权限标识
     *
     * @return permission - 菜单权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置菜单权限标识
     *
     * @param permission 菜单权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取前端URL
     *
     * @return path - 前端URL
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置前端URL
     *
     * @param path 前端URL
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_id - 父菜单ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentId 父菜单ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取排序值
     *
     * @return sort - 排序值
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序值
     *
     * @param sort 排序值
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取0-开启，1- 关闭
     *
     * @return keep_alive - 0-开启，1- 关闭
     */
    public String getKeepAlive() {
        return keepAlive;
    }

    /**
     * 设置0-开启，1- 关闭
     *
     * @param keepAlive 0-开启，1- 关闭
     */
    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive;
    }

    /**
     * 获取菜单类型 （0菜单 1按钮）
     *
     * @return type - 菜单类型 （0菜单 1按钮）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置菜单类型 （0菜单 1按钮）
     *
     * @param type 菜单类型 （0菜单 1按钮）
     */
    public void setType(String type) {
        this.type = type;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取逻辑删除标记(0--正常 1--删除)
     *
     * @return del_flag - 逻辑删除标记(0--正常 1--删除)
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记(0--正常 1--删除)
     *
     * @param delFlag 逻辑删除标记(0--正常 1--删除)
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}