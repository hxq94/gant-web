package cn.lt.gant.common.enums.datasource;

public enum DataSourceEnum {

    MAIN(DBTypeEnum.MySQL),

    OTHER(DBTypeEnum.MySQL);


    private final DBTypeEnum type;

    DataSourceEnum(DBTypeEnum type) {
        this.type = type;
    }

    public DBTypeEnum getValue() {
        return this.type;
    }


}
