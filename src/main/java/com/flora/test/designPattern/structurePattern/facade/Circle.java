package com.flora.test.designPattern.structurePattern.facade;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:54
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
