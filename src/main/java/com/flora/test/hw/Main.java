package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/27-上午11:53
 */
public class Main {
    //HJ1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = 0;
        for (int i = s.length();i > 0; i --){
            String substring = s.substring(i - 1, i);
            if (!substring.equals(" ")){
                res++;
            }else{
                break;//退出循环
            }

        }
        System.out.println(res);
    }
}
