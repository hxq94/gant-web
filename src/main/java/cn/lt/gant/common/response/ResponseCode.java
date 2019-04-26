package cn.lt.gant.common.response;

public interface ResponseCode {
    int SC_OK = 200;
    int SC_BAD_REQUEST = 400;
    int SC_UNAUTHORIZED = 401;
    int SC_METHOD_NOT_ALLOWED = 405;
    int SC_INTERNAL_SERVER_ERROR = 500;
}