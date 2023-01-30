package com.flora.test.designPattern.behavierPattern.strategy;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:07
 */
public class AddOperation implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
