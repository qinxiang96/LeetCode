package com.flora.test.designPattern.behavierPattern.mediator;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:12
 */
public class MediatorDemo {
    public static void main(String[] args) {
        User zhangsan = new User("zhangsan");
        User lisi = new User("lisi");
        zhangsan.sendMessage("去吃饭");
        lisi.sendMessage("好！");


    }
}
