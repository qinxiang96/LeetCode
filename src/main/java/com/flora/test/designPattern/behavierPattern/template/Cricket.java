package com.flora.test.designPattern.behavierPattern.template;

/**
 * @Author qinxiang
 * @Date 2023/6/10-下午11:39
 */
public class Cricket extends Game{
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized. Start playing");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game started. Enjoy the game");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished");
    }
}
