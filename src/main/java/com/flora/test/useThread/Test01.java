package com.flora.test.useThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author qinxiang
 * @Date 2023/1/14-下午6:09
 * 测试CompletableFuture的使用
 */
public class Test01 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        System.out.println("main begin");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread05 begin, 当前线程：" + Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("thread05 end, 运行结果：" + i);
            return i;
        }, executorService).whenComplete((res,exception)->{
            System.out.println("异步任务成功完成，结果是：" + res+ "异常是"+exception);
        });
        System.out.println("main end");


    }

}
