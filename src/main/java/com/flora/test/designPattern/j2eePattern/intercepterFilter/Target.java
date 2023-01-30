package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:15
 */
public class Target {
    public void execute(String request){
        System.out.println("target request is executing:"+request);
    }
}
