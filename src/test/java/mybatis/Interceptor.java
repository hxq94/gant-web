package mybatis;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    Object plugin(Object target);


}
