package com.flora.test.designPattern.structurePattern.proxy;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午4:21
 */
public class RealImage implements Image{
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFile(filename);
    }
    private void loadFile(String filename){
        System.out.println("loading" + filename);
    }

    @Override
    public void display() {
        System.out.println("displaying" + filename);
    }
}
