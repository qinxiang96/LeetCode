package com.flora.test.designPattern.behavierPattern.memento;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:51
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
