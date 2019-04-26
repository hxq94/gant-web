package cn.lt.gant.service.base.impl;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.entity.base.BaseEntity;
import cn.lt.gant.service.base.BaseService;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseDao<T> getDao();
}
