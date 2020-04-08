package com.szm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition{

    private int num =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 新版写法
     * @throws Exception
     */
    public void increment() throws Exception{
        lock.lock();
        try{
            //1. 判断
            while (num !=0){
//                condition.wait();
                condition.await();
            }
            //2.干活
            num++;
            System.out.println(Thread.currentThread().getName()+",执行加操作，num="+num);
            //3.通知
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try{
            //1. 判断
            while (num ==0){
                condition.await();
            }
            //2.干活
            num--;
            System.out.println(Thread.currentThread().getName()+",执行减操作，num="+num);
            //3.通知
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /*public synchronized void increment() throws Exception{
        //1. 判断
//        if(num !=0){
        while (num !=0){
            this.wait();
        }
        //2.干活
        num++;
        System.out.println(Thread.currentThread().getName()+",执行加操作，num="+num);
        //3.通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception{
//        if(num ==0){
        while (num == 0 ){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+",执行减操作，num="+num);
        this.notifyAll();
    }*/
}

/**
 * 1.线程操作资源类
 * 2.判断/干活/通知
 * 3.防止虚假唤醒
 */
public class ProdConsumerDemo04 {

    public static void main(String [] args) throws Exception{
        AirCondition air = new AirCondition();

        new Thread(()->{
            for(int i =0;i<10;i++){
                try{
                    air.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        },"A").start();

        new Thread(()->{
            for(int i =0;i<10;i++){
                try{
                    air.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        },"B").start();
        new Thread(()->{
            for(int i =0;i<10;i++){
                try{
                    air.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        },"C").start();
        new Thread(()->{
            for(int i =0;i<10;i++){
                try{
                    air.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        },"D").start();

    }
}
