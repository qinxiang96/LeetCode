package com.flora.test.designPattern.j2eePattern.servicelocator;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午12:35
 */
public class ServiceLocatorDemo {
    public static void main(String[] args) {
        Service service1 = ServiceLocator.getService("service1");
        service1.execute();
        Service service2 = ServiceLocator.getService("service1");
        service2.execute();
    }
}
