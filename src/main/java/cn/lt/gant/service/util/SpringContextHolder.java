package cn.lt.gant.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (SpringContextHolder.applicationContext != null) {
            return (T) applicationContext.getBean(clazz);
        }
        throw new RuntimeException("SpringContextHolder.applicationContext is null");

    }
}
