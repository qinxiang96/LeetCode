package com.flora.test.designPattern.behavierPattern.template;

/**
 * @Author qinxiang
 * @Date 2023/6/10-下午11:45
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
//        Game game1 = new Football();
//        game1.play();


    }
}
