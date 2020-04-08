package com.szm;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Callable{

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        System.out.println("********callable********");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String [] args) throws Exception{
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        Integer val = (Integer) futureTask.get();
        System.out.println(val);
    }
}
