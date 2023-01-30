package com.flora.test.useThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午6:09
 * 测试CompletableFuture的使用
 */
public class Test02 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main begin");
        CompletableFuture<Integer> future01 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future01 begin, 当前线程：" + Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("future01 end, 运行结果：" + i);
            return i;
        }, executorService).whenComplete((res,exception)->{
            System.out.println("异步任务成功完成，结果是：" + res+ "异常是"+exception);
        });

        CompletableFuture<Integer> future02 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future02 begin, 当前线程：" + Thread.currentThread().getId());
            int i = 10/5;
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future02 end, 运行结果：" + i);
            return i;
        }, executorService);

        CompletableFuture<Object> future3 = future01.applyToEitherAsync(future02, (f1) -> {
            System.out.println("future03 begin, 当前线程：" + Thread.currentThread().getId());
            System.out.println("future03 end, 运行结果：" + f1);
            return 88;

        }, executorService);
        System.out.println("future3的返回值：" + future3.get());
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
