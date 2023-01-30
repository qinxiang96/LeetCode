package com.flora.test.designPattern.j2eePattern.servicelocator;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午12:38
 */
public class Service2 implements Service{
    @Override
    public String getName() {
        return "service2";
    }

    @Override
    public void execute() {
        System.out.println("service2 is executing");
    }
}
