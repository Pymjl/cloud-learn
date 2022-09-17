package cuit.epoch.pymjl.constant;

import lombok.experimental.Accessors;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/5/15 0:17
 **/
@Accessors(chain = true)
public enum ResultEnum {

    /**
     * 未知错误
     */
    UNKNOWN_MISTAKE("发生了未知错误，请联系管理员或稍后重试", false),
    /**
     * 成功
     */
    OK("操作成功", true),
    /**
     * 注册成功
     */
    REGISTER_SUCCESS("注册成功", true),
    /**
     * 没有权限
     */
    PERMISSION_DENIED("没有权限", false),
    /**
     * 身份验证失败
     */
    AUTHENTICATION_FAILED("认证失败", false),

    SENTINEL_FALLBACK_ERROR("Sentinel熔断", false);

    private String msg;
    private Boolean succeed;

    ResultEnum() {
    }

    ResultEnum(String msg, Boolean succeed) {
        this.msg = msg;
        this.succeed = succeed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }
}
