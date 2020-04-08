package com.szm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String [] args) throws Exception{
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
/*//1.抛异常
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
//队列满了再添加就抛异常
//        System.out.println(queue.add("x"));

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//队列空了再移除就抛异常
//        System.out.println(queue.remove());
//队列空了再检查就抛异常
        System.out.println(queue.element());*/

//2.返回特殊值
        /*System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        //队列满了返回false
        System.out.println(queue.offer("x"));

//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        //队列空了返回null
//        System.out.println(queue.poll());//出队
//队列空了返回null
        System.out.println(queue.peek());//检查队首*/

        queue.put("a");
        queue.put("b");
        queue.put("c");
        //队列满了阻塞
//        queue.put("x");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        //队列空了阻塞
        System.out.println(queue.take());

    }
}
