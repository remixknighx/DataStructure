package com.concurrent.master;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Master-Worker模式 通过master将任务分配到worker上去，并获取结果集
 *
 * @author wangjf
 * @date 2018/1/20 0020.
 */
public class Master {

    // 任务队列
    private Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    // worker进程队列
    private Map<String, Thread> threadMap = new HashMap<String, Thread>();
    // 子任务就处理结果集
    private Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    // Master的构造，需要一个进程逻辑，和需要的worker数量
    public Master(Worker worker, int countWorkers){
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorkers; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    // 是否所有的子任务都结束了
    public Boolean isComplete(){
        for(Map.Entry<String, Thread> result: threadMap.entrySet()){
            if(result.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    // 提交一个任务
    public void submit(Object job){
        workQueue.add(job);
    }

    // 返回子任务结果集
    public Map<String, Object> getResultMap(){
        return resultMap;
    }

    // 开始运行所有的worker进程，进行处理
    public void execute(){
        for (Map.Entry<String, Thread> entry: threadMap.entrySet()){
            entry.getValue().start();
        }
    }

}
