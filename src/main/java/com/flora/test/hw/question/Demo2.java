package com.flora.test.hw.question;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/12/21-下午2:37
 * 请写出Java方法，帮助农民实现如下规划资金使用方法的功能：假设某苗木培育基地有且仅有如下三种果苗：1年果苗1元每棵、3年果苗3元每棵、5年果苗5元每棵；农民有资金X元，期望能够尽量买大龄果苗。请写一段程序，在输入农民的资金数额后，输出一个购买方案，示例如下：
 * 输入：104
 * 输出：
 * 5年果苗：20棵
 * 3年果苗：1棵
 * 1年果苗：1课
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int[] ints = methods(x);
            System.out.println("5年果苗：" + ints[0]+"棵");
            System.out.println("3年果苗：" + ints[1]+"棵");
            System.out.println("1年果苗：" + ints[2]+"棵");
        }
    }
    public static int[] methods(int x){
        int[] ints = new int[3];
        ints[0] = x/5;
        x= x%5;
        ints[1] = x/3;
        x= x%3;
        ints[2] = x;
        return ints;
    }
}
