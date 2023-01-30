package com.flora.test.designPattern.j2eePattern.frontcontroller;

/**
 * @Author qinxiang
 * @Date 2022/10/22-下午12:42
 */
public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }
    public boolean isAuthenticUser(){
        System.out.println("authenticUser is pass");
        return true;
    }
    public void trackRequest(String request){
        System.out.println("request is "+ request);
    }
    public void dispatcherRequest(String request){
        trackRequest(request);
        if(isAuthenticUser()) {
            dispatcher.dispath(request);
        }
    }

}
