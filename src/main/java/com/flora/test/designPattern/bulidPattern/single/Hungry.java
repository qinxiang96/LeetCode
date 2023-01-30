package com.flora.test.designPattern.bulidPattern.single;

/**
 * @Author qinxiang
 * @Date 2022/9/30-上午10:33
 */
//饿汉式单例，
public class Hungry {
    //已进入就会创建以下对象，可能会浪费内存
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];
    //构造器私有，一旦私有了，其他人就不可以去new这个对象，保证对象的创建私有了
    private Hungry(){

    }
    private final static Hungry HUNGRY = new Hungry();
    //给外界提供一个方法，去get这个对象，用static保证可见性
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
