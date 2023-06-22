package com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.transaction;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午12:20
 */
public class DaoTransaction {
    public void before(){
        System.out.println("开启事务");
    }
    public void after(){
        System.out.println("关闭事务");
    }
}
