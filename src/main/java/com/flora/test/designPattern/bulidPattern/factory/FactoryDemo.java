package com.flora.test.designPattern.bulidPattern.factory;

/**
 * @Author qinxiang
 * @Date 2022/10/17-下午8:48
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeDraw2 = shapeFactory.getShape("ShapeDraw2");
        shapeDraw2.draw();
    }
}
class ShapeFactory{
    public Shape getShape(String s){
        if(s.equalsIgnoreCase("ShapeDraw")) return new ShapeDraw();
        if(s.equalsIgnoreCase("ShapeDraw2")) return new ShapeDraw2();
        return null;
    }
}
class ShapeDraw implements Shape{

    @Override
    public void draw() {
        System.out.println("ShapeDraw~");
    }
}
class ShapeDraw2 implements Shape{

    @Override
    public void draw() {
        System.out.println("ShapeDraw2~~");
    }
}
interface Shape{
    void draw();
}
