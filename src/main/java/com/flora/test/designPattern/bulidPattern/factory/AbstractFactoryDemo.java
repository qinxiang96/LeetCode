package com.flora.test.designPattern.bulidPattern.factory;

/**
 * @Author qinxiang
 * @Date 2022/10/17-下午10:50
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        BuildFactory buildFactory = new BuildFactory();
        AbstractFactory colorFactory = buildFactory.getFactory("ColorFactory");
        Color blue = colorFactory.getColor("Blue");
        blue.fill();
    }
}
class BuildFactory{
    public AbstractFactory getFactory(String s){
        if (s.equalsIgnoreCase("ColorFactory")) return new ColorFactory();
        if (s.equalsIgnoreCase("ShapeShapeFactory")) return new ShapeShapeFactory();
        return null;
    }
}
class ColorFactory extends AbstractFactory{

    @Override
    public ShapeShape getShape(String s) {
        return null;
    }

    @Override
    public Color getColor(String c) {
        if (c.equalsIgnoreCase("Blue")) return new Blue();
        if (c.equalsIgnoreCase("Red")) return new Red();
        return null;
    }
}
class ShapeShapeFactory extends AbstractFactory{

    @Override
    public ShapeShape getShape(String s) {
        if(s.equalsIgnoreCase("Circle")) return new Circle();
        if(s.equalsIgnoreCase("Line")) return new Line();
        return null;
    }

    @Override
    public Color getColor(String c) {
        return null;
    }
}
abstract class AbstractFactory{
    public abstract ShapeShape getShape(String s);
    public abstract Color getColor(String c);
}
class Red implements Color{

    @Override
    public void fill() {
        System.out.println("红色");
    }
}
class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("蓝色");
    }
}
class Line implements ShapeShape{

    @Override
    public void draw() {
        System.out.println("这是一条line");
    }
}
class Circle implements ShapeShape{

    @Override
    public void draw() {
        System.out.println("这是一个circle");
    }
}

interface Color{
    void fill();
}
interface ShapeShape{
    void draw();
}
