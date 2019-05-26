package com.selune.luckymoney.utils;

import com.selune.luckymoney.domain.Result;

/**
 * @Author: Selune
 * @Date: 5/26/19 5:25 PM
 */

public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
