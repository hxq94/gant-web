package cn.lt.gant.dal.dao.base.impl;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.entity.base.BaseEntity;
import cn.lt.gant.dal.mapper.base.BaseMapper;

public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    protected abstract BaseMapper<T> getMapper();
}
