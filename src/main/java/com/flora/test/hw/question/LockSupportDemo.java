package com.flora.test.hw.question;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author qinxiang
 * @Date 2022/12/20-下午8:22
 * 实现交替输出A1B2C3D4E5E6F7G
 */
public class LockSupportDemo {
    static Thread t1 = null,t2 = null;
    public static void main(String[] args) {
        char[] chars1 = "ABCDEEFG".toCharArray();
        char[] chars2 = "1234567".toCharArray();
        t1 = new Thread(() ->{
            for(char c : chars1){
                System.out.print(c);
                LockSupport.unpark(t2);//叫醒t2
                LockSupport.park();//t1休眠


            }
        }, "t1");
        t2 = new Thread(() ->{
            for(char c : chars2){
                LockSupport.park();//t2挂起
                System.out.print(c);
                LockSupport.unpark(t1);//叫醒t1


            }
        },"t2");
        t1.start();
        t2.start();
    }
}
