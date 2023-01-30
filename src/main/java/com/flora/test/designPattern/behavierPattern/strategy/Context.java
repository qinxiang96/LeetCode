package com.flora.test.designPattern.behavierPattern.strategy;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:09
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public int doStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
