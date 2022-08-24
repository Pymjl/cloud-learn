package cuit.epoch.pymjl.exception;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/20 17:33
 **/
public class AppException extends RuntimeException{
    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
