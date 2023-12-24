package mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Plugin implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target, method, args);
        return interceptor.intercept(invocation);

//        for(Interceptor interceptor : interceptorList){
//
//            interceptor.intercept();
//        }
//
//        Object invoke = method.invoke(target, args);
//
//        return invoke;
    }

    public static Object wrap(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new Plugin(target, interceptor));
    }
}
