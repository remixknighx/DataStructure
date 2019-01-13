package com.interview;

/**
 * @author wangjf
 * @date 2019/1/13 0013.
 */
public class ExceptionTest {

    public static void main(String[] args) throws Exception {
        /**
         * normal method
         * exception
         * finally method
         * finally
         */
        System.out.println(new ExceptionTest().doSomething());
    }

    public String doSomething() throws Exception {
        try {
            System.out.println("normal method");
            throw new Exception("normal Exception");
        } catch (Exception e) {
            System.out.println("exception");
            throw new Exception("catch Exception");
        } finally {
            System.out.println("finally method");
            return "finally";
        }
    }

}
