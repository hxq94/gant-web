package transaction;

import cn.lt.gant.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.TestWeb;

public class TestTransaction extends TestWeb{

    @Autowired
    private UserService userService;


}
