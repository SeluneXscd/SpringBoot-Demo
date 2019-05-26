package com.selune.luckymoney.domain;

import lombok.Data;

/**
 * Http请求返回最外层对象
 * @Author: Selune
 * @Date: 5/26/19 5:23 PM
 */

@Data
public class Result<T> {

    /** 返回状态码 */
    private Integer code;

    /** 返回信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
