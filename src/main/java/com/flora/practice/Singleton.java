package com.flora.practice;

/**
 * @Author qinxiang
 * @Date 2023/2/1-上午11:40
 * 单例模式
 */
public class Singleton {
    // 饿汉式
//    private static Singleton INSTANCE = new Singleton();
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        return INSTANCE;
//    }

    // 懒汉式
//    private static Singleton INSTANCE;
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new Singleton();
//        }
//        return INSTANCE;
//    }
    // 懒汉式-线程安全
//    private static Singleton INSTANCE;
//    private Singleton(){
//
//    }
//    public synchronized static Singleton getInstance(){
//        if (INSTANCE == null){
//            INSTANCE = new Singleton();
//        }
//        return INSTANCE;
//    }
    // 双检模式
//    private static volatile Singleton INSTANCE;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if (INSTANCE == null){
//            synchronized (Singleton.class){
//                if (INSTANCE == null){
//                    INSTANCE = new Singleton();
//                }
//
//            }
//        }
//        return INSTANCE;
//    }

    // 静态内部类单例模式
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return InnerSingleton.INSTANCE;
//    }
//    private static class InnerSingleton{
//        private static final Singleton INSTANCE = new Singleton();
//    }
    // 枚举单例模式 创建枚举类


}
