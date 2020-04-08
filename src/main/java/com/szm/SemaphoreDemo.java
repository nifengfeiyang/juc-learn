package com.szm;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String [] args) throws Exception{
        Semaphore semaphore = new Semaphore(3);

        for(int i =0;i<6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }

    }
}
