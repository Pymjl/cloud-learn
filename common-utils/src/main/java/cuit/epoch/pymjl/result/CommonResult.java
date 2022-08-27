package cuit.epoch.pymjl.result;

import cuit.epoch.pymjl.constant.ResultEnum;

import java.io.Serializable;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/20 16:21
 **/
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T result;
    private Boolean succeed;
    private String message;

    public CommonResult() {
    }

    public CommonResult(ResultEnum resultEnum) {
        this.result = null;
        this.succeed = resultEnum.getSucceed();
        this.message = resultEnum.getMsg();
    }

    public CommonResult(T result, ResultEnum resultEnum) {
        this.result = result;
        this.succeed = resultEnum.getSucceed();
        this.message = resultEnum.getMsg();
    }

    public CommonResult(T result, Boolean succeed, String message) {
        this.result = result;
        this.succeed = succeed;
        this.message = message;
    }

    public CommonResult(Boolean succeed, String message) {
        this.result = null;
        this.succeed = succeed;
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", succeed=" + succeed +
                ", message='" + message + '\'' +
                '}';
    }
}
