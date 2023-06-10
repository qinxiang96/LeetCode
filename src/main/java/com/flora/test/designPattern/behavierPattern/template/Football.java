package com.flora.test.designPattern.behavierPattern.template;

/**
 * @Author qinxiang
 * @Date 2023/6/10-下午11:43
 */
public class Football extends Game{
    @Override
    void initialize() {
        System.out.println("Football Game Initialized. Start playing");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game started. Enjoy the game");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished");
        System.out.println("add another");
    }
}
