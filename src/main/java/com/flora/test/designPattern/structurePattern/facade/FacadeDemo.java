package com.flora.test.designPattern.structurePattern.facade;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:53
 * 外观模式
 */
public class FacadeDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
    }
}
