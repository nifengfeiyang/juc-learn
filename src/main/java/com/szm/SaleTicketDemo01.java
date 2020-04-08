package com.szm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    int number = 30;
    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try{
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + ",当前正在卖第"+ number-- +"张票，还剩"+ number+"张");
            }
        }finally {
            lock.unlock();
        }
    }
}

public class SaleTicketDemo01 {

    public static void main(String [] args){
        Ticket ticket = new Ticket();


        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++ ){
                    ticket.sale();
                }
            }
        },"A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++ ){
                    ticket.sale();
                }
            }
        },"B");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 40; i++ ){
                    ticket.sale();
                }
            }
        },"C");

        t1.start();
        t2.start();
        t3.start();*/

        new Thread(()->{ for(int i = 0; i < 40; i++ ) { ticket.sale(); } },"A").start();
        new Thread(()->{ for(int i = 0; i < 40; i++ ) { ticket.sale(); } },"B").start();
        new Thread(()->{ for(int i = 0; i < 40; i++ ) { ticket.sale(); } },"C").start();
    }
}
