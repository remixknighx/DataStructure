package com.reactor;

/**
 * @author wangjf
 * @date 2019/3/17 0017.
 */
public enum Report {

    EMPRPT(1, "ONE"), MNGPRT(2, "TWO");
    private String name;
    private int id;

    Report(int id, String name){

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }
}
