package com.flora.test.designPattern.behavierPattern.chain;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午8:38
 */
public class FileLogger extends AbstractLogger{
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    void write(String message) {
        System.out.println("file logger:" + message);
    }
}
