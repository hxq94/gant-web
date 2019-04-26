package cn.lt.gant.web.interceptor.base;

import cn.lt.gant.common.response.ResponseCode;
import cn.lt.gant.dal.util.DataPipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限控制拦截器
 *
 * @author lt
 * @version 1.0.0
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    /**
     * 开始时间记录器
     */
    private static final ThreadLocal<Long> SLOW_REQUEST_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 日志记录器
     */
    protected final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    /**
     * 响应数据日志记录器
     */
    private final Logger responseLogger = LoggerFactory.getLogger("response-data-log");

    /**
     * 慢请求日志记录器
     */
    private final Logger slowLogger = LoggerFactory.getLogger("slow-request-log");

    /**
     * 请求前的预处理（进行编码、安全控制等处理）
     */
    @Override
    public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 处理开始时间
        SLOW_REQUEST_THREAD_LOCAL.set(System.currentTimeMillis());

        // 请求前的预处理
        return preHandleBase(request, response, handler);
    }

    /**
     * 请求前的预处理（进行编码、安全控制等处理） 子类应该重写此方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandleBase(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Nothing(子类应该重写此方法)
        return true;
    }

    /**
     * 请求处理后的处理
     */
    @Override
    public final void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {

        // 请求处理后的处理(子类的处理方式)
        postHandleBase(request, response, handler, mv);

        // 如果mv为null 返回200
        if (mv != null) {
            DataPipe.in(mv).meta(ResponseCode.SC_OK);
        }
    }

    /**
     * 请求处理后的处理 子类应该重写此方法
     *
     * @param request
     * @param response
     * @param handler
     * @param mv
     * @return
     * @throws Exception
     */
    public void postHandleBase(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        // Nothing(子类应该重写此方法)
    }

    /**
     * 请求处理完成后的处理
     */
    @Override
    public final void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        try {
            // 请求处理完成后的处理(子类的处理方式)
            afterCompletionBase(request, response, handler, ex);

            // 处理结束时间
            long overTimes = System.currentTimeMillis();
            // 处理时长
            long runtime = (overTimes - SLOW_REQUEST_THREAD_LOCAL.get());
            // 处理时长大于3000毫秒的处理将被记录
            if (runtime > 3000) {
                String requestURI = request.getRequestURI();
                String queryString = request.getQueryString();

            }

        } finally {

            // 清除本地线程缓存
            SLOW_REQUEST_THREAD_LOCAL.remove();
        }

    }

    /**
     * 请求处理完成后的处理 子类应该重写此方法
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletionBase(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Nothing(子类应该重写此方法)
    }

}
