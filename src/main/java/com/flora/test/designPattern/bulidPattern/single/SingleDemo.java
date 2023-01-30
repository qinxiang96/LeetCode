package com.flora.test.designPattern.bulidPattern.single;

/**
 * @Author qinxiang
 * @Date 2022/10/17-下午8:00
 */
public class SingleDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.getMessage();

    }

}
class Singleton{
    private static Singleton Instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        //System.out.println("单例模式被创建");
        return Instance;
    }
    public static void getMessage(){
        System.out.println("单例模式被创建");
    }

}
