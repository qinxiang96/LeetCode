package com.flora.test.designPattern.j2eePattern.frontcontroller;

/**
 * @Author qinxiang
 * @Date 2022/10/22-下午12:35
 */
public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }
    public void dispath(String request){
        if(request.equalsIgnoreCase("home")){
            homeView.show();
        }else if(request.equalsIgnoreCase("student")){
            studentView.show();
        }else {
            System.out.println("request is invalid");
        }

    }
}
