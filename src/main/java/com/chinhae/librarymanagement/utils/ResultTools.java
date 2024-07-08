package com.chinhae.librarymanagement.utils;

import com.chinhae.librarymanagement.result.Result;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/8 14:45
 * @version: 1.0
 */
public class ResultTools {
    public static Result result(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
