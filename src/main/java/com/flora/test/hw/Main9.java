package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/31-下午10:46
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围： 1 \le n \le 10^{8} \1≤n≤10
 * 8
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 复制
 * 输出：
 * 37689
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        String num2 = new StringBuffer(num).reverse().toString();
        char[] num3 = num2.toCharArray();
        for(int i =0;i<num2.length();i++){
            //indexOf返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
            if(i==num2.indexOf(num3[i])){
                System.out.print(num3[i]);
            }else{
                System.out.print("");
            }
        }


    }
}
