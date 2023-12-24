package mybatis;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {


    public static void main(String[] args) {

        Target target  = new TargetImpl();

        List<Interceptor> interceptorList = Lists.newArrayList();

        Interceptor loginInterceptor  = new LoginInterceptor();
        Interceptor logInterceptor  = new LogInterceptor();

        interceptorList.add(loginInterceptor);
        interceptorList.add(logInterceptor);

        InterceptorStack interceptorStack = new InterceptorStack();
        interceptorStack.registerAll(interceptorList);

        Target t = (Target)interceptorStack.pluginAll(target);

        t.execute();
    }
}
