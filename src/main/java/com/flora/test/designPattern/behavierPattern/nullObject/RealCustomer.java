package com.flora.test.designPattern.behavierPattern.nullObject;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午2:12
 */
public class RealCustomer extends AbstractCustomer{
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
