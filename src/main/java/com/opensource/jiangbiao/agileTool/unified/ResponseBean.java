package com.opensource.jiangbiao.agileTool.unified;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:16 PM
 */
public class ResponseBean<T>{


    private ResponseCode status;

    private String message;

    private T data;

    public HttpStatus getHttpStatus(){
        HttpStatus httpStatus= HttpStatus.OK;
        int code=Integer.valueOf(status.getCode());
        if (code>=ResponseCode.OK.getCode()) {
            httpStatus= HttpStatus.valueOf(code);
        }
        return httpStatus;
    }

    public ResponseCode getStatus() {
        return status;
    }

    public void setStatus(ResponseCode status) {
        this.status = status;
        String message = CodeMapMessage.map.get(status.getCode());
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
