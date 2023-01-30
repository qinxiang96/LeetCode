package com.flora.test.designPattern.behavierPattern.nullObject;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午2:30
 */
public class CustomerFactory {
    public static final String[] names = {"yihao","erhao","sanhao"};
    public static AbstractCustomer getCustomer(String name){
        for (int i = 0; i < names.length;i ++){
            if(names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
