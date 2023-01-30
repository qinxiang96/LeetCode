package com.flora.test.initThread;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午3:20
 * ## 1、初始化线程的4种方式
 *  *
 *  * 2）、实现 Runnable 接口 ，重写run方法，new对象，new Thread(传入对象)，调用Thread的start方法
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread02 thread02 = new Thread02();
        new Thread(thread02).start();
        System.out.println("main end");
    }
    public static class Thread02 implements Runnable{

       @Override
        public void run() {
           System.out.println("Tread02 begin，当前线程：" + Thread.currentThread().getId());
           int i = 10/2;
           System.out.println("Tread02 end, 运行结果：" + i);
       }
    }
}
