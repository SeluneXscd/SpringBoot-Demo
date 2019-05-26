package com.selune.luckymoney.enums;

/**
 * @Author: Selune
 * @Date: 5/26/19 8:03 PM
 */

public enum ResultEnum {

    /**
     *     UNKNOWN_ERROR(-1, "未知异常"),
     *     SUCCESS(0, "成功")
     */
    UNKNOWN_ERROR(-1, "未知异常"),
    SUCCESS(0, "成功")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
