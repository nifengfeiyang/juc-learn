package com.szm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String [] args) throws Exception{

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("*****召唤神龙*****");
        });

        for(int i =0;i<7;i++){
            final int num = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集第"+num+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
