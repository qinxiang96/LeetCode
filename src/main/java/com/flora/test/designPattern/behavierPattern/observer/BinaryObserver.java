package com.flora.test.designPattern.behavierPattern.observer;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午5:56
 */
public class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("binary String:" + Integer.toBinaryString(subject.getState()));
    }
}
