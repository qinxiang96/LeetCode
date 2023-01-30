package com.flora.test.designPattern.behavierPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/20-上午10:46
 * 命令调用类
 */
public class Broker {
    private List<Order> list = new ArrayList<>();
    public void takeOrder(Order order){
        list.add(order);
    }
    public void placeOrder(){
        for(Order order: list){
            order.execute();
        }
        list.clear();
    }
}
