package com.flora.test.designPattern.behavierPattern.state;

/**
 * @Author qinxiang
 * @Date 2022/10/21-上午10:50
 */
public class StateDemo {
    public static void main(String[] args) {
        StartState startState = new StartState();
        Context context = new Context();
        startState.doState(context);
        System.out.println(context.getState().toString());
        System.out.println(context.toString());;
        System.out.println(startState.toString());;

    }
}
