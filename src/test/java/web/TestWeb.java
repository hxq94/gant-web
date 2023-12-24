package web;

import cn.lt.gant.service.user.UserService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 需要spring注入功能需要继承
 *
 * @author lt
 * @date 2019-04-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:biz/**/biz-*.xml")
public class TestWeb {

    @Autowired
    private UserService userService;

    @Test
    public void getUserService() {
        userService.updateById();
    }

    @Test
    public void asyncSendMessageAfterTransactionCommit(){
        userService.asyncSendMessageAfterTransactionCommit();
    }

    @Test
    public void testMybatis(){

        for (Integer i:Lists.newArrayList(1,2)){
            System.out.println(i);
        }

        userService.selectList();
    }
}
