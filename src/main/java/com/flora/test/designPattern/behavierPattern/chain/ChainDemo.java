package com.flora.test.designPattern.behavierPattern.chain;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午6:12
 */
public class ChainDemo {
    private static AbstractLogger getChainOfLoggers(){
        ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        FileLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        ConsoleLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
    public static void main(String[] args) {
        AbstractLogger chainOfLoggers = getChainOfLoggers();
        //chainOfLoggers.logMessage(AbstractLogger.INFO,"this is a info message");
//        chainOfLoggers.logMessage(AbstractLogger.DEBUG,"this is a debug message");
        chainOfLoggers.logMessage(AbstractLogger.ERROR,"this is a error message");

    }
}
