package com.flora.test.initThread;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午3:03
 * ## 1、初始化线程的4种方式
 *
 * 1）、继承Thread，重写run方法，new对象，调用对象的start方法
 *
 * 运行结果：
 * main begin
 * main end
 * Tread01 begin
 * Tread01 end, 运行结果：5
 */
public class ThreadTest01{
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread01 thread01 = new Thread01();
        thread01.start();
        System.out.println("main end");

    }
    public static class Thread01 extends Thread{
        @Override
        public void run() {
            System.out.println("Tread01 begin");
            int i = 10/2;
            System.out.println("Tread01 end, 运行结果：" + i);        }
    }
}
