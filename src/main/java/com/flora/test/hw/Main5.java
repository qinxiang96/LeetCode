package com.flora.test.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/30-下午10:57
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 */
public class Main5 {
    //方法二：
    private  final static int BASE = 16;
    private final static Map<Character, Integer> hashMap = new HashMap<Character, Integer>(){
        {put('0',0);
        put('1',1);
        put('2', 2);
        put('3',3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('a', 10);
        put('b', 11);
        put('c', 12);
        put('d', 13);
        put('e', 14);
        put('f', 15);
            put('A', 10);
            put('B', 11);
            put('C', 12);
            put('D', 13);
            put('E', 14);
            put('F', 15);
        }
    };

    public static int getValue(String s){
        int res = 0;
        for (Character c : s.toCharArray()) {
            res = res * BASE + hashMap.get(c);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){//判断是否还有输入
            String s = scanner.nextLine();//以enter为结束符
            int value = getValue(s.substring(2));
            System.out.println(value);
        }

        //方法一：
//        while(scanner.hasNext()){
//            String s = scanner.nextLine();
//            System.out.println(Integer.parseInt(s.replaceAll("x", ""),16));
//
//        }

    }
}
