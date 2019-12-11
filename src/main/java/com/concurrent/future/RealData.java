package com.concurrent.future;

import java.util.concurrent.Callable;

/**
 * @author wangjf
 * @date 2018/1/20 0020.
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para){
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(200);
            sb.append(para);
        }
        return sb.toString();
    }
}
