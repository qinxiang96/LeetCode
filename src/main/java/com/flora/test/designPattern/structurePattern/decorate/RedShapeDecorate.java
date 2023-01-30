package com.flora.test.designPattern.structurePattern.decorate;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:26
 */
public class RedShapeDecorate extends ShapeDecorate{
    public RedShapeDecorate(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRed(shape);
        //System.out.println("Red decorating");
    }
    private void setRed(Shape shape){
        System.out.println("Red decorating");
    }
}
