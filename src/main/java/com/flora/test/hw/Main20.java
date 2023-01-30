package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/5-下午10:50
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 复制
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            if(s.length() > 8){
                int a=0,b=0,e=0,d=0;
                boolean err = true;
                for (char c : chars){
                    if(c >='0' && c <= '9'){
                        a = 1;
                    }else if(c >= 'a' && c <= 'z'){
                        b = 1;
                    }else if(c >= 'A' && c <= 'Z'){
                        e = 1;
                    }else if (c == ' ' || c == '\n'){
                        err = false;
                        break;

                    }else {
                        d = 1;
                    }
                }
                if (err){
                    if(a+b+d+e >= 3){
                        if (reStr(s)){
                            System.out.println("OK");
                        }else{
                            System.out.println("NG");
                        }
                    }else{
                        System.out.println("NG");
                    }
                }else {
                    System.out.println("NG");
                }
            }else {
                System.out.println("NG");
            }
        }
    }
    private static boolean reStr(String s){
        for(int i = 3; i < s.length(); i ++){
            if(s.substring(i).contains(s.substring(i - 3, i))){
                return false;
            }
        }
        return true;
    }
}
