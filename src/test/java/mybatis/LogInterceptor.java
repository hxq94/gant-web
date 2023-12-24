package mybatis;

import java.lang.reflect.InvocationTargetException;

public class LogInterceptor extends AbstractInterceptor {
    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before mybatis.LogInterceptor#intercept");
        return invocation.process();
    }
}
