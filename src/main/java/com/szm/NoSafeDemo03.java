package com.szm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1.问题：java.util.ConcurrentModificationException
 */
public class NoSafeDemo03 {
    public static void main(String [] args){
//        noSafeList();
//        noSafeSet();
        noSafeMap();
    }

    private static void noSafeMap() {
        Map<String,String> map =  new HashMap<>();
        for(int i =0;i < 30;i++){
            new Thread( () -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i) ).start();
        }
    }

    private static void noSafeSet() {
        Set<String> set =  new CopyOnWriteArraySet<>();//new HashSet<>();
        for(int i =0;i < 30;i++){
            new Thread( () -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i) ).start();
        }
    }

    private static void noSafeList() {
        List<String > list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>()); //new Vector<>(); //new ArrayList<String>();
        for(int i =0;i < 30;i++){
            new Thread( () -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i) ).start();
        }
    }
}
