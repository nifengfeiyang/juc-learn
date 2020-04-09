package com.szm;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大函数式接口
 */
public class FunctionDemo {
    public static void main(String[] args) throws Exception {
/*        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/
        //消费型
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("java~");


/*        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "java 222";
            }
        } ;*/
        //供给型
        Supplier<String> supplier = () -> {
            return "java222";
        };
        System.out.println(supplier.get());

        //函数型
/*        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };*/
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("java"));

        //判定型
/*        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("java"));

    }
}