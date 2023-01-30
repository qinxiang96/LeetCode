package com.flora.test.designPattern.structurePattern.decorate;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午11:22
 */
public abstract class ShapeDecorate implements Shape{
    protected Shape shape;//为什么要用protected修饰？如果是私有的，那么继承这个抽象类的实体类无法调用该对象;protected本包+所有子类

    public ShapeDecorate(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
