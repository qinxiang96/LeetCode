package com.flora.test.designPattern.behavierPattern.state;

/**
 * @Author qinxiang
 * @Date 2022/10/21-上午10:54
 */
public class StartState implements State{
    @Override
    public void doState(Context context) {
        System.out.println("player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState{}";
    }
}
