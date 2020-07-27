package com.hax.common.mybatis.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * extends BaseDO 扩展 delete 操作
 *
 * @author Sin
 * @time 2019-03-22 22:03
 */
public class DeletableDO extends BaseDO {

    /**
     * 是否删除
     */
    @TableLogic
    private Integer delFlag;

    @Override
    public String toString() {
        return "DeletableDO{" +
                "deleted=" + delFlag +
                '}';
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public DeletableDO setDeleted(Integer deleted) {
        this.delFlag = deleted;
        return this;
    }

}
