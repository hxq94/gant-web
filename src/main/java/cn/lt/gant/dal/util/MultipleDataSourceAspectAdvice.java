package cn.lt.gant.dal.util;

import cn.lt.gant.common.anotation.DataSourceType;
import cn.lt.gant.common.enums.datasource.DataSourceEnum;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Mapper切面
 *
 * @author lt
 * @version 1.0.0
 */
public class MultipleDataSourceAspectAdvice {

    /**
     * 拦截切面，获取目标数据源(切面表达式biz-database.xml里面修改)
     *
     * @param jp
     * @return
     * @throws Throwable
     */
    public Object doAround(final ProceedingJoinPoint jp) throws Throwable {

        DataSourceType ds = null;

        Class<?>[] interfaceList = jp.getTarget().getClass().getInterfaces();
        if (interfaceList != null && interfaceList.length > 0) {
            ds = interfaceList[0].getAnnotation(DataSourceType.class);
        }

        if (MultipleDataSource.getDataSourceKey() == null) {
            if (ds == null) {
                // 默认主库
                MultipleDataSource.setDataSourceKey(DataSourceEnum.MAIN);
            } else {
                MultipleDataSource.setDataSourceKey(ds.target());
            }
        }

        System.out.println("log....");
        System.out.println("log1");
        System.out.println("log2....");
        try {
            //调用被拦截方法
            return jp.proceed();
        } finally {
            MultipleDataSource.setDataSourceKey(null);
        }
    }
}
