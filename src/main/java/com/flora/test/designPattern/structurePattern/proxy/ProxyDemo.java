package com.flora.test.designPattern.structurePattern.proxy;

/**
 * @Author qinxiang
 * @Date 2022/10/19-下午4:20
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("wooo.avi");
        proxyImage.display();
        proxyImage.display();
    }
}
