package com.flora.test.hw.question;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author qinxiang
 * @Date 2022/12/20-下午8:48
 */
public class TransferQueueDemo {
    public static void main(String[] args) {
        char[] c1 = "ABCDEFG".toCharArray();
        char[] c2 = "1234567".toCharArray();
        LinkedTransferQueue<Object> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try{
                for(Character c : c1){
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try{
                for(Character c : c2){
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }, "t2").start();

    }
}
