package com.dk.core.result;

/**
 * 接口返回状态码
 * @autor kevin.dai
 * @Date 2018/10/9
 */
public enum CodeMsg {

    SUCCESS(2000,"请求成功"),
    USER_NOT_FOUND(5001,"用户不存在");

    private int resultCode;

    private String resultMsg;


    CodeMsg(int resultCode,String resultMsg){
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }


    public int getResultCode(){
        return resultCode;
    }


    public String getResultMsg(){
        return resultMsg;
    }



}
