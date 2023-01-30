package com.flora.test.designPattern.behavierPattern.chain;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午8:35
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("error logger:" + message);
    }
}
