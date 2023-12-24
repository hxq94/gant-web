package cn.lt.gant.dal.mapper.main.user;

import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.dal.mapper.base.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    void selectBYCache();
}