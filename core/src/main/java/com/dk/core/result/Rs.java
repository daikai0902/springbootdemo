package com.dk.core.result;

/**
 * 返回结果
 * @autor kevin.dai
 * @Date 2018/9/29
 */
public class Rs<T>{



    public int code = 2000;


    public String message = "succ";


    public T data;





    public Rs(int code, String message){
        this.code = code;
        this.message = message;
    }


    public Rs(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
