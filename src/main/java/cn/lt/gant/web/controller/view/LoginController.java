package cn.lt.gant.web.controller.view;

import cn.lt.gant.dal.mapper.main.user.UserMapper;
import cn.lt.gant.dal.util.PageHelper;
import cn.lt.gant.service.user.UserService;
import cn.lt.gant.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController extends BaseController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        PageHelper.startPage(1, 10, true);
        userMapper.selectAll();
        return "login";

    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void testTrans() {
        userService.updateById();
    }
}
