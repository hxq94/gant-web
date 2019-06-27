package cn.lt.gant.web.resolve.exception;


import cn.lt.gant.common.response.ResponseCode;
import cn.lt.gant.dal.util.DataPipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 错误解析器（实现spring mvc全局错误解析器）
 *
 * @author lt
 * @version 1.0
 */
@Component
public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

    /**
     * 日志记录器
     */
    private final Logger logger = LoggerFactory.getLogger(HandlerExceptionResolver.class);
    /**
     * 响应数据日志记录器
     */
    private final Logger responseLogger = LoggerFactory.getLogger("response-data-log");


    /**
     * 异常处理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        final ModelAndView mav = new ModelAndView();
        int code = ResponseCode.SC_INTERNAL_SERVER_ERROR;
        String message = "服务器开小差了，请稍后重试！";

        // ex为空直接返回500

        // 记录日志

        // 设置meta信息
        DataPipe.in(mav).meta(code, message);

        // 记录请求返回数据
        if (responseLogger.isDebugEnabled()) {

        }

        return mav;
    }
}
