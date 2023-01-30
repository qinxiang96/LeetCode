package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/7-上午9:46
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 示例1
 * 输入：
 * YUANzhi1987
 * 复制
 * 输出：
 * zvbo9441987
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i ++){
            if(chars[i] >= 0 && chars[i] < 10){
                continue;
            }else if(chars[i] >= 'a' && chars[i] <= 'c'){
                chars[i] = '2';
            }else if(chars[i] >= 'd' && chars[i] <= 'f') {
                chars[i] = '3';
            }else if(chars[i] >= 'g' && chars[i] <= 'i'){
                chars[i] = '4';
            }else if(chars[i] >= 'j' && chars[i] <= 'l'){
                chars[i] = '5';
            }else if(chars[i] >= 'm' && chars[i] <= 'o'){
                chars[i] = '6';
            }else if(chars[i] >= 'p' && chars[i] <= 's'){
                chars[i] = '7';
            }else if(chars[i] >= 't' && chars[i] <= 'v'){
                chars[i] = '8';
            }else if(chars[i] >= 'w' && chars[i] <= 'z'){
                chars[i] = '9';
            }else if(chars[i] >= 'A' && chars[i] <= 'Y'){
                chars[i] = (char) (chars[i] +33);
            }else if(chars[i] == 'Z'){
                chars[i] = 'a';
            }
        }
        for(char c : chars){
            System.out.print(c);
        }
    }
}
