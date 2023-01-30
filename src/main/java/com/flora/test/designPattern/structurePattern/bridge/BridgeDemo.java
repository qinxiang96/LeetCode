package com.flora.test.designPattern.structurePattern.bridge;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午5:59
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(new BlueCircle(), 3, 1, 1);
        circle.draw();
    }
}
//桥接实现接口
interface DrawAPI{
    public void drawCircle(int radio, int x,int y);
}
//实体的桥接实现类
class BlueCircle implements DrawAPI{

    @Override
    public void drawCircle(int radio, int x, int y) {
        System.out.println("BlueCircle: radio:" + radio+ " x:" + x + " y:" + y);
    }
}
class RedCircle implements DrawAPI{

    @Override
    public void drawCircle(int radio, int x, int y) {
        System.out.println("RedCircle: radio:" + radio+ "x:" + x + "y:" + y);
    }
}
//抽象类Shape,用DrawAPI接口创建
abstract class Shape{
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
class Circle extends Shape{
    private int radio, x,y;

    public Circle(DrawAPI drawAPI, int radio, int x, int y) {
        super(drawAPI);
        this.radio = radio;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radio,x,y);
    }
}
