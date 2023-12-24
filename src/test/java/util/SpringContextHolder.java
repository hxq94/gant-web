package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
