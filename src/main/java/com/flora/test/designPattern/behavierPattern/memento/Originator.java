package com.flora.test.designPattern.behavierPattern.memento;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:53
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Memento saveStateToMemento(){
        Memento memento = new Memento(state);
        return memento;
    }
    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
