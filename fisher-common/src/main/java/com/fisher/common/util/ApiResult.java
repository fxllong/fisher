package com.fisher.common.util;

import com.fisher.common.enums.ResponseCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 统一响应信息主体
 */
@Data
public class ApiResult<T> implements Serializable {

    private T data;

    private Integer code = ResponseCodeEnum.SUCCESS.getCode();

    private String message = ResponseCodeEnum.SUCCESS.getMessage();

    public ApiResult() {
    }

    public ApiResult(T data) {
        this.data = data;
    }

    public ApiResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ApiResult(T data, ResponseCodeEnum responseCode) {
        this.data = data;
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public ApiResult(Throwable throwable) {
        this.message = throwable.getMessage();
        this.code = ResponseCodeEnum.FAIL.getCode();
    }

    public ApiResult(Throwable throwable, ResponseCodeEnum  code) {
        this.message = throwable.getMessage();
        this.code = code.getCode();
    }


}
