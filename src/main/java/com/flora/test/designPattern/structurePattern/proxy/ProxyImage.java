package com.flora.test.designPattern.structurePattern.proxy;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午4:29
 */
public class ProxyImage implements Image{
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(filename);//注意 这里是将属性进行赋值，不要创建一个新对象RealImage realImage = new RealImage(filename)
        }
        realImage.display();
    }
}
