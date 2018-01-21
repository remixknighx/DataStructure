package com.concurrent.guard;

/**
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
