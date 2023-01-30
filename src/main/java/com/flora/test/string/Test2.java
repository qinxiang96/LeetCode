package com.flora.test.string;

import java.util.Arrays;

/**
 * @Author qinxiang
 * @Date 2022/11/23-上午9:21
 * 如何判断两个字符串是否由相同的字符组成
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(compare("aabcc", "baacc"));
    }
    //方法一：排序法
    //比较排序后的字符串是否相等 equals方法
    public static boolean compare(String a,String b){
        char[] c1 = a.toCharArray();
        Arrays.sort(c1);
        char[] c2 = b.toCharArray();
        Arrays.sort(c2);
        a = new String(c1);
        b = new String(c2);
        if(a.equals(b)){
            return true;
        }
        return false;
    }
    //方法二：空间换时间
    public static boolean compare2(String a, String b){
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        //申请大小为256的数组来记录各个字符出现的个数，并初始化为0
        int[] count = new int[256];
        for(int i = 0; i < 256; i ++){
            count[i] = 0;
        }
        for(int i = 0; i < c1.length; i ++){
            //TODO
        }
        return false;
    }
}
