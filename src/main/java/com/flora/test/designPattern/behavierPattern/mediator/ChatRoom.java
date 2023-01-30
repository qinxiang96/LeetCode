package com.flora.test.designPattern.behavierPattern.mediator;

import java.util.Date;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午3:14
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        String s = new Date().toString();
        System.out.println(s+" user:"+user.getName()+" send a message:"+message);
    }

}
