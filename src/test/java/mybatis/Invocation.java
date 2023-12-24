package mybatis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {

    private Object target;

    private Method method;

    private Object [] args;


    public Invocation(Object target, Method method, Object[] args) {
        this.method = method;
        this.target = target;
        this.args = args;
    }

    public Object process() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,args);
    }
}
