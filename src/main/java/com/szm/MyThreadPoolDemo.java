package com.szm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String [] args) throws Exception{
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            for(int i =0;i< 10;i++){
                final int num = i;
                executorService.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"-->处理" + num + "任务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
