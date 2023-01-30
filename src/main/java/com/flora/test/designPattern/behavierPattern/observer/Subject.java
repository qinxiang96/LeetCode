package com.flora.test.designPattern.behavierPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午5:30
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void attach(Observer object){
        observers.add(object);
    }
    public void notifyAllObservers(){
        for (Observer observer:observers){
            observer.update();
        }
    }
}
