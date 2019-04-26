package cn.lt.gant.web.interceptor;

import cn.lt.gant.web.interceptor.base.BaseInterceptor;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 页面权限控制
 *
 * @author lt
 * @version 1.0.0
 */
public final class HandlerInterceptor extends BaseInterceptor {


    /**
     * 请求前的预处理（进行编码、安全控制等处理）
     */
    @Override
    public boolean preHandleBase(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod == false) {
            return true;
        }

        final String requestURI = request.getRequestURI();

        // 过滤IE11以下版本

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();

        // 取得请求Controller方法的权限注释

        // 权限验证

        //从请求参数[PC，Ajax]获取、没有的话从cookie[PC，Ajax]获取、没有的话从header[App]获取

        // 权限验证


        // 没有权限返回 401


        return true;
    }

}
