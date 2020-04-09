package com.szm;



import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String [] args) throws Exception{
        //计算机核数
        int coreNum = Runtime.getRuntime().availableProcessors();
        //int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue,
        //                              ThreadFactory threadFactory,
        //                              RejectedExecutionHandler handler
        ExecutorService executorService = new ThreadPoolExecutor(3,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
                );

        try{
//            for(int i =0;i< 8;i++){
            for(int i =0;i< 9;i++){//拒绝策略被执行
                final int num = i;
                executorService.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"-->处理" + num + "任务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
            System.out.println(Thread.currentThread().getName()+"-->关闭资源");
        }
    }

/*
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
            System.out.println(Thread.currentThread().getName()+"-->关闭资源");
        }
    }
*/
}
