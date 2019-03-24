package com.concurrent.cp;

/**
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class PCData {

    private int intData;

    public PCData(int intData){
        this.intData = intData;
    }

    public PCData(String d){
        intData = Integer.valueOf(d);
    }

    public int getIntData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
