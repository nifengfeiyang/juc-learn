package com.szm;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String [] args) throws Exception{
//        level();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i =0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("班长关门走人");
    }

    private static void level() {
        for(int i =0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开");
            },String.valueOf(i)).start();
        }

        System.out.println("班长关门走人");
    }
}
