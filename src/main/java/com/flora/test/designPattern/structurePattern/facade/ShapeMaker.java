package com.flora.test.designPattern.structurePattern.facade;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:55
 */
public class ShapeMaker{
    private Shape circle;
    private Shape line;

    public ShapeMaker( ) {
        circle = new Circle();
        line = new Line();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawLine(){
        line.draw();
    }
}
