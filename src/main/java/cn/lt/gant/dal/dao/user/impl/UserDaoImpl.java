package cn.lt.gant.dal.dao.user.impl;

import cn.lt.gant.dal.dao.base.impl.BaseDaoImpl;
import cn.lt.gant.dal.dao.user.UserDao;
import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.dal.mapper.base.BaseMapper;
import cn.lt.gant.dal.mapper.main.user.UserMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 * 
 * @author Administrator 2019-6-27
 * @since 南阳理工学院
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    
    /**
     * UserMapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * Mapper初始化
     *
     * @return
     */
    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}