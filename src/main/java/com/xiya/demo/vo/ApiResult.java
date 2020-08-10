package com.xiya.demo.vo;


import com.xiya.demo.enumtype.ServerCode;

/**
 * @author n3verl4nd
 * @date 2020/3/24
 */
public class ApiResult<T> {

    /**
     * 错误码，0 代表成功，其他代表失败
     */
    private int code;

    /**
     * 错误信息，对应错误码
     */
    private String msg;

    /**
     * 业务数据
     */
    private T data;

    public ApiResult() {
    }

    public ApiResult(ServerCode serverCode, T data) {
        this.code = serverCode.getCode();
        this.msg = serverCode.getMessage();
        this.data = data;
    }

    public ApiResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ApiResult<T> wrapSuccess(T data) {
        return new ApiResult<>(ServerCode.SUCCESS, data);
    }

    public static <T> ApiResult<T> newResult(ServerCode serverCode) {
        return new ApiResult<>(serverCode, null);
    }

    public static <T> ApiResult<T> newResult(ServerCode serverCode, T data) {
        return new ApiResult<>(serverCode, data);
    }

    public static <T> ApiResult<T> newResult(int code, String msg) {
        return new ApiResult<>(code, msg, null);
    }

    public static <T> ApiResult<T> newResult(int code, String msg, T data) {
        return new ApiResult<>(code, msg, data);
    }

}
