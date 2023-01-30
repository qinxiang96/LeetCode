package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/27-上午11:57
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        String target = scanner.next();
        int res = 0;
        for (int i = 0;i < s.length();i++){
            if (target.equalsIgnoreCase(s.substring(i,i+1))){
                res++;
            }

        }
        System.out.println(res);
    }
}
