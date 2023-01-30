package com.flora.test.designPattern.behavierPattern.state;

/**
 * @Author qinxiang
 * @Date 2022/10/21-上午10:59
 */
public class StopState implements State{

    @Override
    public void doState(Context context) {
        System.out.println("player is in a stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StopState{}";
    }
}
