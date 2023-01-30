package com.flora.test.designPattern.j2eePattern.servicelocator;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午12:37
 */
public class Service1 implements Service{

    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("service1 is executing");
    }
}
