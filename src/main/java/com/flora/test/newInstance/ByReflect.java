package com.flora.test.newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author qinxiang
 * @Date 2022/10/24-下午4:47
 */
public class ByReflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //通过类调用newInstance(),调用的是无参的构造方法
        ByReflect byReflect = ByReflect.class.newInstance();//调用无参构造方法，当写入了有参构造方法后，无参构造方法就不默认存在了，需要创建有无参构造方法存在
        byReflect.add(1,2);
        //通过构造器调用newInstance()，调用的是有参的构造方法
        Constructor<ByReflect> declaredConstructor = ByReflect.class.getDeclaredConstructor(String.class);
        ByReflect o = (ByReflect) declaredConstructor.newInstance("xixi");
        o.add(3,2);

        //测试反射的几种方式
        //Class.forName("类的路径")
        Class<?> byReflect1 = Class.forName("com.flora.test.newInstance.ByReflect");//类的路径
        ByReflect o1 = (ByReflect) byReflect1.newInstance();
        o1.add(3,3);
        //类名.class
        Class<ByReflect> byReflect3 = ByReflect.class;
        //对象名.getClass()
        Class<? extends ByReflect> byReflect2 = o1.getClass();
        ByReflect o2 = byReflect2.newInstance();
        o2.add(1,1);


    }

    public ByReflect() {
    }

    public ByReflect(String name) {
        System.out.println("name="+name);
    }

    public void add(int a, int b){
        int c = a + b;
        System.out.println("a+b="+c);
    }


}
