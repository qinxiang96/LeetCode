package com.flora.test.designPattern.structurePattern.flyweight;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午3:12
 */
public class Circle {
    private String color;
    private int x;
    private int y;
    private int radio;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    public void draw(){
        System.out.println("drawing circle: color:" + color+" x:" +x+" y:"+y+" radio:"+radio);
    }
}
