package com.jlife.test.exception;

/**
 * Created by chen on 2017/3/17.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class TestException {

    public void throwsTest() throws SaveException {
        throw new SaveException("用户保存错误");
    }

    public void throwTest(String d) throws SaveException {
        if ("ddd".equals(d)) {
            if ("d".equals(d)) {
                System.out.print("dd0");
            } else {
                throw new SaveException("用户保存错误");
            }
            System.out.print("dd0");
        }
    }

    public static void main(String[] args){

    }

}
