package com.flora.test.hw.string;

/**
 * @Author qinxiang
 * @Date 2022/11/23-下午3:50
 * 如何输出字符串的所有组合
 * 输入"abc",输出a、b、c、ab、ac、bc、abc
 * 如果有n个字符，根据排列组合的性质，一共需输出2^n - 1种组合
 */
public class Test6 {
    public static void main(String[] args) {
        String s = "abc";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        int len = c.length;
        for (int i = 1; i <= len; i ++){
            combineRecursiveImpl(c,0,i,sb);
        }
    }
    //方法一：递归法
    public static void combineRecursiveImpl(char[] c, int begin, int len, StringBuffer sb){
        if(len == 0){
            System.out.print(sb + " ");
            return;
        }
        if(begin == c.length){
            return;
        }
        sb.append(c[begin]);
        combineRecursiveImpl(c, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        combineRecursiveImpl(c, begin + 1, len,sb);
    }
}
