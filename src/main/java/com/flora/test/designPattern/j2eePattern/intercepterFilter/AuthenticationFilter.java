package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:13
 */
public class AuthenticationFilter implements Filter{
    @Override
    public void execute() {
        System.out.println("authentication is pass");
    }
}
