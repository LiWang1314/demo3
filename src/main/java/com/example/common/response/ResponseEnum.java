package com.example.common.response;
/**
 * @author
 * @Description: 定义返回状态枚举
 * @date
 */
public enum ResponseEnum {
    SUCCESS(1, "请求成功"),//接口正常返回
    FAIL(0, "请求失败"),//请求失败，一般是参数校验没有通过
    SERVICE_EXCEPTION(2, "业务异常"),//业务层异常
    SERVER_ERROR(3, "程序异常"),//程序异常，一般是bug，需要排查解决
    NOT_LOGIN(4, "您尚未登陆，无调用接口权限"),
    REQUEST_ILLEGAL(5, "非法请求：token验证未通过"),
    TOKEN_EXPIRED(6,"请求未受理：token令牌已经过期");
    private Integer code;
    private String message;
    ResponseEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
}
