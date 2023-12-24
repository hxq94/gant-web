package mybatis;

import java.util.List;

public class InterceptorStack {

    private List<Interceptor> interceptorList;

    public void registerAll(List<Interceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public Object pluginAll(Object target) {

        for (Interceptor interceptor : interceptorList) {
            target = interceptor.plugin(target);
        }
        return target;
    }

}
