package mybatis;

import java.lang.reflect.InvocationTargetException;

public class AbstractInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        return invocation.process();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }
}
