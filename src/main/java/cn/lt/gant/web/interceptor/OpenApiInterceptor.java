package cn.lt.gant.web.interceptor;

import cn.lt.gant.common.anotation.AuthCheck;
import cn.lt.gant.common.exception.DataErrorException;
import cn.lt.gant.common.response.ResponseCode;
import cn.lt.gant.web.interceptor.base.BaseInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 开放平台接口权限控制
 *
 * @author lt
 * @version 1.0.0
 */
public final class OpenApiInterceptor extends BaseInterceptor {

    /**
     * 开放平台应用用户Service
     */
//    @Resource
//    private OpenApiUserService openApiUserService;

    /**
     * 请求前的预处理（进行编码、安全控制等处理）
     */
    @Override
    public boolean preHandleBase(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod == false) {
            return true;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();

        // 取得请求Controller方法的权限注释
        final AuthCheck authCheck = method.getAnnotation(AuthCheck.class);

        // 权限验证
        if (authCheck != null) {

            //应用ID
            String appKey = request.getHeader("App-Key");
            if (StringUtils.isBlank(appKey)) {
                throw new DataErrorException(ResponseCode.SC_UNAUTHORIZED, "请求头中不存在【 App-Key 】");
            }

            //应用秘钥
            String appSecret = request.getHeader("App-Secret");
            if (StringUtils.isBlank(appSecret)) {
                throw new DataErrorException(ResponseCode.SC_UNAUTHORIZED, "请求头中不存在【 App-Secret 】");
            }

            //如果第三方提供的密钥不匹配  则抛出异常
            throw new DataErrorException(ResponseCode.SC_UNAUTHORIZED, "App-Key或App-Secret错误");
        }

        return true;
    }

}
