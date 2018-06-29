package com.kyle.miaosha.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }


    /**
     * 失败调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }


    public Result(T data) {
        this.data = data;
        this.code = CodeMsg.SUCCESS.getCode();
        this.msg = CodeMsg.SUCCESS.getMsg();
    }


    public Result(CodeMsg codeMsg) {
        if (codeMsg == null){
            return;
        }

        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }



    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public int getCode() {
        return code;
    }



    public String getMsg() {
        return msg;
    }



    public T getData() {
        return data;
    }


}
