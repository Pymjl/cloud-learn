package cuit.epoch.pymjl.result;


import cuit.epoch.pymjl.constant.ResultEnum;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/20 16:22
 **/
public class ResultUtils {
    public static CommonResult<String> success() {
        return new CommonResult<>(ResultEnum.OK);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(data, ResultEnum.OK);
    }

    public static CommonResult<String> success(Boolean succeed, String message) {
        return new CommonResult<>(succeed, message);
    }

    public static CommonResult<String> success(ResultEnum resultEnum) {
        return new CommonResult<>(resultEnum);
    }

    public static CommonResult<String> fail() {
        return new CommonResult<>(ResultEnum.UNKNOWN_MISTAKE);
    }

    public static CommonResult<String> fail(String message) {
        return new CommonResult<>(false, message);
    }

    public static <T> CommonResult<T> fail(T data) {
        return new CommonResult<>(data, ResultEnum.UNKNOWN_MISTAKE);
    }

    public static <T> CommonResult<T> fail(ResultEnum resultEnum) {
        return new CommonResult<>(resultEnum);
    }
}
