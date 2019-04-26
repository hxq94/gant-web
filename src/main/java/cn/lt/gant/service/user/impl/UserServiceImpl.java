package cn.lt.gant.service.user.impl;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.dao.user.UserDao;
import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.service.base.impl.BaseServiceImpl;
import cn.lt.gant.service.user.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService
 * 
 * @author ulf 2019-4-25
 * @since 南阳理工学院
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    /**
     * UserDao
     */
    @Resource
    private UserDao userDao;

    /**
     * Mapper初始化
     *
     * @return
     */
    @Override
    protected BaseDao<User> getDao() {
        return userDao;
    }
}