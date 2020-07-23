package com.hax.common.mybatis.service.impl;


import com.hax.common.mybatis.mapper.MyBaseMapper;
import com.hax.common.mybatis.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected MyBaseMapper<T> myBaseMapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        myBaseMapper.insertSelective(model);
    }

    public void save(List<T> models) {
        myBaseMapper.insertList(models);
    }

    public void deleteById(Object id) {
        myBaseMapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        myBaseMapper.deleteByIds(ids);
    }

    public void update(T model) {
        myBaseMapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Integer id) {
        return myBaseMapper.selectByPrimaryKey(id);
    }


    public List<T> findByIds(String ids) {
        return myBaseMapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return myBaseMapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return myBaseMapper.selectAll();
    }
}
