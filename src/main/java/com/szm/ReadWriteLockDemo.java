package com.szm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private volatile Map<String,String> myCache = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key ,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入");
            Thread.sleep(300);
            myCache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取");
            String val = myCache.get(key);
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + "读取完成");
            return val;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void main(String [] args) throws Exception{
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        for(int i =0;i<5;i++){
            final int tempNu = i;
            new Thread(()->{
                try {
                    demo.put(String.valueOf(tempNu),""+tempNu);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                }

            },String.valueOf(i)).start();
        }

        for(int i =0;i<5;i++){
            final int tempNu = i;
            new Thread(()->{
                try {
                    demo.get(String.valueOf(tempNu));
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                }

            },String.valueOf(i)).start();
        }

    }
}
