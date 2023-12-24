package mybatis;

import java.lang.reflect.InvocationTargetException;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before mybatis.LoginInterceptor#intercept");
        return invocation.process();
    }

}
