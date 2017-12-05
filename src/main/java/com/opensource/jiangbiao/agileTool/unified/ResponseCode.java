package com.opensource.jiangbiao.agileTool.unified;

/**
 * @author Jiang Biao
 * @date 11/12/2017 2:18 PM
 */
public enum ResponseCode {

    FAILED(0),
    SUCCESS(1),
    ACCOUNT_EXIST(11),
    ADD_USER_SUCESS(12),
    PROJECT_EXIST(13),
    OK(200),
    BAD_REQUEST(400);

    private int code = 0 ;
    ResponseCode(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
