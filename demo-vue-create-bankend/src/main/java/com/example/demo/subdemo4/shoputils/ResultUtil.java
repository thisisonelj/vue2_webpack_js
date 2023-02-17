package com.example.demo.subdemo4.shoputils;

import java.util.Date;

public class ResultUtil<T> {
    /**
     * 成功
     * @return
     */
    public static <T> ResultUtil<T> resultSuccessful() {
        return new ResultUtil<T>() ;
    }
    /**
     * 成功
     * @param data 返回数据
     * @return
     */
    public static <T> ResultUtil<T> resultSuccessful(T data) {
        return new ResultUtil<T>(data) ;
    }
    /**
     * 成功
     * @param status 状态码
     * @param msg 返回信息
     * @param data 返回数据
     */
    public static <T> ResultUtil<T> resultSuccessful(Integer status,String msg, T data) {
        return new ResultUtil<T>(status,msg,data) ;
    }
    public static <T> ResultUtil<T> resultSuccessful(ResultCode ResultCode, T data) {
        return new ResultUtil<T>(ResultCode.getStatus(),ResultCode.getMsg(),data) ;
    }
    /**
     * 失败
     * @return
     */
    public static <T> ResultUtil<T> resultFailure() {
        return new ResultUtil<T>(ResultCode.NORMAL_ERROR.getStatus(),ResultCode.NORMAL_ERROR.getMsg(),null) ;
    }
    /**
     * 失败
     * @param data
     * @return
     */
    public static <T> ResultUtil<T> resultFailure(T data) {
        return new ResultUtil<T>(ResultCode.NORMAL_ERROR.getStatus(),ResultCode.NORMAL_ERROR.getMsg(),data) ;
    }
    /**
     * 失败
     * @param status 状态码
     * @param msg 返回信息
     * @param data 返回数据
     */
    public static <T> ResultUtil<T> resultFailure(Integer status,String msg, T data) {
        return new ResultUtil<T>(status,msg,data) ;
    }
    public static <T> ResultUtil<T> resultFailure(ResultCode ResultCode, T data) {
        return new ResultUtil<T>(ResultCode.getStatus(),ResultCode.getMsg(),data) ;
    }
    /**
     * 失败
     * @param status 状态码
     * @param msg 返回信息
     * @param data 返回数据
     */
    public static <T> ResultUtil<T> resultFailure(Integer status,String msg) {
        return new ResultUtil<T>(status,msg,null) ;
    }

    public static <T> ResultUtil<T> resultFailure(ResultCode ResultCode) {
        return new ResultUtil<T>(ResultCode.getStatus(),ResultCode.getMsg(),null) ;
    }

    /**
     * 响应业务状态
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应的数据
     */
    private T data;

    private Date timestamp = new Date() ;
    /**
     * @param status 状态码
     * @param msg 返回信息
     * @param data 返回数据
     */
    private ResultUtil(Integer status,String msg, T data) {
        this.status = status ;
        this.msg = msg;
        this.data = data ;
    }
    private ResultUtil(T data) {
        this.data = data ;
        this.status = ResultCode.SUCCESS.getStatus();
        this.msg = ResultCode.SUCCESS.getMsg() ;
    }

    private ResultUtil() {
        this.status = ResultCode.SUCCESS.getStatus();
        this.msg = ResultCode.SUCCESS.getMsg() ;
    }
    public Integer getStatus() {
        return status;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }
    public Date getTimestamp() {
        return timestamp;
    }
}
