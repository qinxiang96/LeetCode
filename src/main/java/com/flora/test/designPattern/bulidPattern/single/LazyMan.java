package com.flora.test.designPattern.bulidPattern.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author qinxiang
 * @Date 2022/9/30-上午10:49
 */
//懒汉式单例
public class LazyMan {
    private static boolean qinjiang = false;
    //构造器私有化
    private LazyMan(){
        synchronized (LazyMan.class){
//            if (lazyMan != null){
//                throw new RuntimeException("不要试图使用反射破坏异常");//只能解决第一个对象已正常创建，第二个对象用反射进行创建的情况；但如果两个对象都用反射创建，不可拦截
//                // 解决方案：先定义一个boolean,对boolean值进行修改，该值在类调用时进行修改，只能修改一次，如果已经被修改了，则抛异常
//
//            }
            if(qinjiang == false){
                qinjiang = true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
    }
    private volatile static LazyMan lazyMan;
    //双重检测锁模式的懒汉式单例，DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    //1.分配内存空间 2.执行构造方法，初始化对象 3. 把这个对象指向这个空间
                    //123 但A 132 到达3此时lazyMan还没有完成构造，B认为lazyMan==null
                    //解决方案：使用volatile进行修饰，禁止指令重排，使得其具有有效性
                }
            }
        }

        return lazyMan;
    }
    //反射
    public static void main(String[] args) throws Exception{
        Field qinjiang = LazyMan.class.getDeclaredField("qinjiang");
        qinjiang.setAccessible(true);

        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        //通过反射将qinjiang设置成false，又可以创建了
        qinjiang.set(instance, false);

        LazyMan instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
