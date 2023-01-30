package com.flora.test.designPattern.structurePattern.decorate;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:21
 */
public class Line implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Line");
    }
}
