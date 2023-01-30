package com.flora.test.designPattern.behavierPattern.strategy;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:04
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        System.out.println(context.doStrategy(2,4));
    }
}
