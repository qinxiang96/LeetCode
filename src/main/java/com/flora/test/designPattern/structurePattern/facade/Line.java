package com.flora.test.designPattern.structurePattern.facade;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:55
 */
public class Line implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing line");
    }
}
