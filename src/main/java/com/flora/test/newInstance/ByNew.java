package com.flora.test.newInstance;

/**
 * @Author qinxiang
 * @Date 2022/10/24-下午4:43
 */
public class ByNew {
    public static void main(String[] args) {
        ByNew byNew = new ByNew();
        byNew.add(3,4);
    }
    public void add(int a,int b){
        int c = a + b;
        System.out.println("a+b="+c);
    }
}
