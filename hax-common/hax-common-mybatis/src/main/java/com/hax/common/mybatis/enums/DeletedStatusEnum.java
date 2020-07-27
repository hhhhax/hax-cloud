package com.hax.common.mybatis.enums;

import com.hax.common.mybatis.dataobject.DeletableDO;

/**
 * {@link DeletableDO#getDelFlag()} ()} delete 状态
 *
 * @author Sin
 * @time 2019-03-22 21:15
 */
public enum DeletedStatusEnum {

    DELETED_NO(0, "正常(未删除)"),
    DELETED_YES(1, "删除");

    /**
     * 状态值
     */
    private Integer value;
    /**
     * 状态名
     */
    private String name;

    DeletedStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}