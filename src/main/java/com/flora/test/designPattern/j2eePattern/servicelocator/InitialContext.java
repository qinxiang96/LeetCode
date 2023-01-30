package com.flora.test.designPattern.j2eePattern.servicelocator;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午12:47
 */
public class InitialContext {
    public Service lookUp(String name){
        if(name.equalsIgnoreCase("service1")){
            System.out.println("looking up service1 and new service1");
            return new Service1();
        }else if(name.equalsIgnoreCase("service2")){
            System.out.println("looking up service2 and new service2");
            return new Service2();
        }
        return null;
    }
}
