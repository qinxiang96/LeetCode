package com.flora.test.designPattern.behavierPattern.state;

/**
 * @Author qinxiang
 * @Date 2022/10/21-上午10:51
 */
public class Context {
    private State state;

    public Context() {

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Context{" +
                "state=" + state +
                '}';
    }
}
