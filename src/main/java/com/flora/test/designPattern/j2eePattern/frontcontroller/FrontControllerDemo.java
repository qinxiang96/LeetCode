package com.flora.test.designPattern.j2eePattern.frontcontroller;

/**
 * @Author qinxiang
 * @Date 2022/10/22-下午12:32
 */
public class FrontControllerDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatcherRequest("studt");
    }
}
