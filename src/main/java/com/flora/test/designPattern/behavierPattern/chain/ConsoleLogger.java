package com.flora.test.designPattern.behavierPattern.chain;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午6:27
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("console logger:" + message);
    }
}
