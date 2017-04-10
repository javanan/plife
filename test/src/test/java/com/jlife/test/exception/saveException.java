package com.jlife.test.exception;

/**
 * Created by chen on 2017/3/17.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class SaveException extends Exception {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SaveException() {

    }

    public SaveException(String msg) {
        this.msg = msg;
    }
}
