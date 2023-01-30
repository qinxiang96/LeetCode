package com.flora.test.initThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午4:00
 * 1、初始化线程的4种方式
 * 4) 线程池 实现 Runnable 接口 ，重写run方法，new对象, Executors.newFixedThreadPool(线程数)，作为常量放在前面，调用execute(传入对象)
 *
 */
public class ThreadTest04 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        System.out.println("main begin，当前线程：" + Thread.currentThread().getId());
        // 当前系统中池只有一两个，每个异步任务，提交给线程池去执行
        executorService.execute(new Thread04());
        System.out.println("main end");
    }
    public static class Thread04 implements Runnable{

        @Override
        public void run() {
            System.out.println("thread04 begin, 当前线程：" + Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("thread04 end, 运行结果：" + i);
        }
    }
}
