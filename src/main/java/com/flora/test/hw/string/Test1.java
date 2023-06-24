package com.flora.test.hw.string;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午8:54
 * 如何实现字符串的反转
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "how are you";
        String s1 = reverseString(s);
        System.out.println(s1);

    }
    public static String reverseString(String s){
        char[] chars = s.toCharArray();
        //对整个字符串进行字符反转操作
        reverse(chars, 0, chars.length - 1);
        int begin = 0;
        //对每个单词进行字符反转操作
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] == ' '){
                reverse(chars, begin, i - 1);
                begin = i + 1;
            }
        }
        //' '后面最后一个单词需要继续处理
        reverse(chars,begin,chars.length - 1);
        return new String(chars);
    }
    public static void reverse(char[] c,int begin,int end){
        while(begin < end){
            char tmp = c[end];
            c[end] = c[begin];
            c[begin] = tmp;
            begin ++;
            end --;
        }
    }
}
