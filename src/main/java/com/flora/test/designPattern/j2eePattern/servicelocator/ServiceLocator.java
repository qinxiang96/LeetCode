package com.flora.test.designPattern.j2eePattern.servicelocator;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午1:36
 */
public class ServiceLocator {
    private static Cache cache;
    static{
        cache = new Cache();
    }
    public static Service getService(String name){
        Service service = cache.getService(name);
        if (service != null){
            return service;
        }
        InitialContext initialContext = new InitialContext();
        Service service1 = initialContext.lookUp(name);
        cache.addService(service1);
        return service1;
    }
}
