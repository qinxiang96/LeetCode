package com.flora.test.initThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午3:39
 * 1、初始化线程的4种方式
 *
 * 3）、实现 Callable 接口 ，重写call方法，new对象，new FutureTask<>(传入对象)，new Thread(传入FutureTask对象)，调用Thread的start方法
 * futureTask.get() // 可以得到返回结果
 */
public class ThreadTest03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main begin，当前线程：" + Thread.currentThread().getId());
        Thread03 thread03 = new Thread03();
        FutureTask futureTask = new FutureTask<>(thread03);
        Thread thread = new Thread(futureTask);
        thread.start();

        Object o = futureTask.get();
        System.out.println(o);

        System.out.println("main end");
    }
    public static class Thread03 implements Callable {

        @Override
        public Object call() {
            System.out.println("Tread03 begin，当前线程：" + Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("Tread03 end, 运行结果：" + i);
            return i;
        }
    }
}
