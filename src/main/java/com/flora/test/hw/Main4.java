package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/10/30-下午10:03
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            int size = s.length();
            int addZero = 8 - size%8;
            while(addZero > 0 && addZero < 8){
                stringBuilder.append("0");
                addZero --;
            }
            String s1 = stringBuilder.toString();
            while(s1.length() > 0){
                System.out.println(s1.substring(0,8));
                s1 = s1.substring(8);
            }
        }

    }
}
