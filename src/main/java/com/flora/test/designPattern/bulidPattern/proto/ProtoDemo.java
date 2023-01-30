package com.flora.test.designPattern.bulidPattern.proto;

import java.util.Hashtable;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午2:37
 */
public class ProtoDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println("Shape type:" +cloneShape.type);
        cloneShape.draw();
    }
}
//创建一个类，从数据库获取实体类，保存在ShapeCache中的Hashtable
class ShapeCache{
    private static Hashtable<String,Shape> hashtable = new Hashtable<String,Shape>();
    public static Shape getShape(String shapeId){
        Shape cacheShape = hashtable.get(shapeId);
        return (Shape) cacheShape.clone();//有这个方法 是因为Shape类实现了Cloneable接口

    }
    //数据库查询，创建形状
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        hashtable.put(circle.getId(), circle);

        Line line = new Line();
        line.setId("2");
        hashtable.put(line.getId(), line);
    }
}
class Line extends Shape{
    public Line() {
        type = "Line";
    }

    @Override
    void draw() {
        System.out.println("Line");
    }
}
class Circle extends Shape{
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Circle");
    }
}
//实现了Cloneable接口的抽象类
abstract class Shape implements Cloneable{
    private String id;
    protected String type;
    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
