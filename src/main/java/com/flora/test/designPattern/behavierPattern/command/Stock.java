package com.flora.test.designPattern.behavierPattern.command;

/**
 * @Author qinxiang
 * @Date 2022/10/20-上午10:35
 * 请求类 买卖商品
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 5;
    public void buy(){
        System.out.println(" buy stock name:" + name+" quantity:"+quantity);
    }
    public void sell(){
        System.out.println("sell stock name:"+name+" quantity:"+quantity);
    }
}
