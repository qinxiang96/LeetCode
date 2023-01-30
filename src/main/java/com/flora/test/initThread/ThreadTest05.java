package com.flora.test.initThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午4:33
 * 1、初始化线程的4种方式
 * 4、线程池 new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit unit, workQueue, threadFactory, handler);
 */
public class ThreadTest05 {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
        System.out.println("main begin");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(new Thread05());
        executor.shutdown();
        System.out.println("main end");

    }
    public static class Thread05 implements Runnable{

        @Override
        public void run() {
            System.out.println("thread05 begin, 当前线程：" + Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("thread05 end, 运行结果：" + i);
        }
    }
}
