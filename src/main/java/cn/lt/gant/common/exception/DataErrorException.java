package cn.lt.gant.common.exception;

public class DataErrorException extends RuntimeException {

    private Integer errorCode;
    private String message;


    public DataErrorException(Integer errorCode, String message) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
