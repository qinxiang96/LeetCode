package com.flora.test.designPattern.behavierPattern.memento;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:50
 */
public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("1hao");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("2hao");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("3hao");
        careTaker.add(originator.saveStateToMemento());
        Memento memento = careTaker.get(2);
        originator.getStateFromMemento(memento);
        String state = originator.getState();
        System.out.println(state);
    }
}
