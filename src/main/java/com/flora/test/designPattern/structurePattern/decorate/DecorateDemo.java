package com.flora.test.designPattern.structurePattern.decorate;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:20
 */
public class DecorateDemo {
    public static void main(String[] args) {
        RedShapeDecorate redShapeDecorate = new RedShapeDecorate(new Circle());
        redShapeDecorate.draw();

        Line line = new Line();
        line.draw();
    }
}
