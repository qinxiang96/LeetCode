package com.flora.test.hw;

import java.util.*;

/**
 * @Author qinxiang
 * @Date 2022/11/1-下午5:52
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        List<String> list = new ArrayList<>();
        while (i > 0) {
            //String s = scanner.nextLine();
            list.add(scanner.next());
            --i;
        }
        Collections.sort(list);
        for(int j = 0; j < list.size(); j ++){
            System.out.println(list.get(j));
        }
    }
}
