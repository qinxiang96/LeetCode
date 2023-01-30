package com.flora.test.designPattern.behavierPattern.nullObject;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午2:22
 */
public class NullCustomer extends AbstractCustomer{
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "there has not needed name";
    }
}
