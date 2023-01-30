package com.flora.test.designPattern.behavierPattern.state;

/**
 * @Author qinxiang
 * @Date 2022/10/21-上午11:01
 */
public class MoveState implements State{
    @Override
    public void doState(Context context) {
        System.out.println("player is in a move state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "MoveState{}";
    }
}
