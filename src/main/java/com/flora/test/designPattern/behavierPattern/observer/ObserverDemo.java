package com.flora.test.designPattern.behavierPattern.observer;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午5:30
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        //binaryObserver.update();
        OctalObserver octalObserver = new OctalObserver(subject);
        //subject.notifyAllObservers();
        //octalObserver.update();
        subject.setState(6);



    }
}
