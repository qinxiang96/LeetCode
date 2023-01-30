package com.flora.test.designPattern.structurePattern.flyweight;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午3:11
 */
public class FlyweightDemo {
    private static String colors[] = {"yellow","blue","red","black","white"};
    public static void main(String[] args) {
        Circle shape1 = ShapeFactory.getCircle("blue");//此时被创建出来保存在hashmap中
        Circle shape = ShapeFactory.getCircle("blue");
        shape.setRadio(1);
        shape.setX(1);
        shape.setY(1);
        shape.draw();
    }
}
