package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:14
 */
public class DebugFilter implements Filter{
    @Override
    public void execute() {
        System.out.println("debug log is done");
    }
}
