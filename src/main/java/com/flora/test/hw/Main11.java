package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/1-下午12:02
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2
 * 30
 *  −1
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：
 * 1516000
 * 复制
 * 输出：
 * 0006151
 */
public class Main11 {
    //方法一：
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String s = scanner.nextLine();
//            String s1 = new StringBuilder(s).reverse().toString();
//            System.out.println(s1);
//        }
//    }
    //方法二：
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i=0;
        String res="";

        while(num!=0){
            int t1=num%10;
            int t2=num/10;
            res=res+String.valueOf(t1);
            i++;
            num=t2;
        }
        System.out.println(res);
    }
}
