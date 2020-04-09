package com.szm;

import java.util.concurrent.CompletableFuture;

/**
 * 异步回调
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
/*        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println("-------------exec----------------");
        });
        completableFuture.get();*/

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println("-------------exec--------------");
            int num = 10/0;
            return 1024;
        });

        int result = completableFuture2.whenComplete((t,u)->{
            System.out.println("*******u:"+u);
            System.out.println("*******t:"+t);
             })
                .exceptionally(t -> {
                    System.out.println("*******t:"+t);
                    return 4444;
                })
                .get();
        System.out.println("*******result:"+result);
    }

}
