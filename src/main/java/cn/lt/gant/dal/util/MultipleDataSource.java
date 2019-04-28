package cn.lt.gant.dal.util;

import cn.lt.gant.common.enums.datasource.DataSourceEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    /**
     * 存放dataSource的ThreadLocal
     */
    private static final ThreadLocal<DataSourceEnum> dataSourceKey = new InheritableThreadLocal<>();


    public static DataSourceEnum getDataSourceKey() {
        return dataSourceKey.get();
    }

    public static void setDataSourceKey(DataSourceEnum dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {

        if (dataSourceKey.get() == null) {
            return DataSourceEnum.MAIN;
        }
        return dataSourceKey.get().getValue();
    }
}
