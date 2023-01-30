package com.flora.test.designPattern.structurePattern.flyweight;

import java.util.HashMap;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午3:17
 */
public class ShapeFactory {
    private static final HashMap<String, Circle> hashMap = new HashMap<>();
    public static Circle getCircle(String color){
        Circle shape = (Circle) hashMap.get(color);
        if (shape == null){
            Circle circle = new Circle(color);
            hashMap.put(color, circle);
            System.out.println("creating a circle");

        }
        return  shape;
    }
}
