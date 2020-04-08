package com.szm;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int num =1; //标志：1:A 2:B 3:C
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();//一把锁配3把钥匙
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() throws Exception{
        lock.lock();
        try{
            //1.判断
            while (num != 1){
                c1.await();
            }
            //2.干活
            for(int i=0; i<5; i++){
                System.out.println("线程"+ Thread.currentThread().getName()+","+i);
            }
            //3.通知
            num = 2;
            c2.signal();//精确打击
        }finally {
            lock.unlock();
        }
    }
    public void print10() throws Exception{
        lock.lock();
        try{
            //1.判断
            while (num != 2){
                c2.await();
            }
            //2.干活
            for(int i=0; i<10; i++){
                System.out.println("线程"+ Thread.currentThread().getName()+","+i);
            }
            //3.通知
            num = 3;
            c3.signal();//精确打击
        }finally {
            lock.unlock();
        }
    }
    public void print15() throws Exception{
        lock.lock();
        try{
            //1.判断
            while (num != 3){
                c3.await();
            }
            //2.干活
            for(int i=0; i<15; i++){
                System.out.println("线程"+ Thread.currentThread().getName()+","+i);
            }
            //3.通知
            num = 1;
            c1.signal();//精确打击
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 要求：A线程打印5次，B线程打印10次，C线程打印15次
 * 来10轮
 */
public class ConditionDemo05 {

    public static void main(String [] args) throws Exception {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();
    }
}
