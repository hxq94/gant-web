package cn.lt.gant.dal.dao.user;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.entity.main.user.User;

/**
 * UserDao
 * 
 * @author Administrator 2019-6-27
 * @since 南阳理工学院
 */
public interface UserDao extends BaseDao<User> {
    void updateById(User user);
}