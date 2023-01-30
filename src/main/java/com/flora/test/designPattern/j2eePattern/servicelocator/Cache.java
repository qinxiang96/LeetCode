package com.flora.test.designPattern.j2eePattern.servicelocator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午12:52
 */
public class Cache {
    private List<Service> services;

    public Cache() {
        services = new ArrayList<>();
    }
    public Service getService(String name){
        for (Service service:services){
            if (name.equalsIgnoreCase(service.getName())){
                return service;
            }
        }
        return null;

    }
    public void addService(Service service){
        boolean exist = false;
        for (Service service1:services){
            if (service.getName().equalsIgnoreCase(service1.getName())){
                exist = true;
            }
        }
        if(!exist) {
            services.add(service);
        }
    }
}
