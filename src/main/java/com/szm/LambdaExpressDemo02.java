package com.szm;

/**
 * 函数式接口
 * 1、函数式接口可以定义多个default方法
 * 2、函数式接口可以定义多个static方法
 */
@FunctionalInterface
interface  Foo{
//    void sayHi();
    int add(int x,int y);

    public default int mul(int x ,int y){
        return x * y;
    }
    public static  int div (int x ,int y){
        return x / y;
    }
}

/**
 * 拷贝小括号，写死右箭头，落地大括号
 */
public class LambdaExpressDemo02 {
    public static void main(String [] args){
//        Foo foo = new Foo() {
//            @Override
//            public void sayHi() {
//                System.out.println("hi~");
//            }
//        };
//        foo.sayHi();

//        Foo foo = () -> { System.out.println("hi~"); };
//        foo.sayHi();

        Foo foo = (int x,int y) -> { return x + y; };

        System.out.println(foo.add(3,5));

        System.out.println(foo.mul(3,5));

    }
}
