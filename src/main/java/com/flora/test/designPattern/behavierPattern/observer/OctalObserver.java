package com.flora.test.designPattern.behavierPattern.observer;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午6:43
 */
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("octal String:" + Integer.toOctalString(subject.getState()));
    }
}
