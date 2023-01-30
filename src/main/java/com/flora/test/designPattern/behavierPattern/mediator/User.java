package com.flora.test.designPattern.behavierPattern.mediator;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:12
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
