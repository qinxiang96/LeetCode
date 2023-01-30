package com.flora.test.designPattern.behavierPattern.observer;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午5:32
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
