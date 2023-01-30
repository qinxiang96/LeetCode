package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/31-下午6:07
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            double s = scanner.nextDouble();
            //方法一：
            //System.out.println((int)(s+0.5));
            //方法二：
            int r = (int)s;
            if((s-r)>=0.5 && (s-r)<1){
                r++;
            }
            System.out.println(r);

        }
    }
}
