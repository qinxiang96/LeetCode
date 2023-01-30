package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/1-下午10:29
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = Integer.toBinaryString(i);
        int res = 0;
        for(int j = 0; j < s.length(); j ++){
            if(s.charAt(j) == '1'){
                res ++;
            }
        }
        System.out.println(res);
    }
}
