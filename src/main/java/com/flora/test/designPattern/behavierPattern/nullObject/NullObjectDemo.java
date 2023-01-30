package com.flora.test.designPattern.behavierPattern.nullObject;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午12:23
 */
public class NullObjectDemo {

    public static void main(String[] args) {
        AbstractCustomer wangwu = CustomerFactory.getCustomer("wangwu");
        System.out.println(wangwu.getName());
        AbstractCustomer yihao = CustomerFactory.getCustomer("yihao");
        System.out.println(yihao.getName());
    }
}
