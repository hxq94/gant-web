package mybatis;

import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.dal.mapper.main.user.UserMapper;
import org.junit.Test;
import web.TestWeb;

import javax.annotation.Resource;

public class TestMybatis extends TestWeb {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testTkMapper() {
        User user = new User();
        user.setUserId(1L);
        userMapper.selectOne(user);
    }
}
