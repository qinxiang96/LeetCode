package com.flora.test.string;

/**
 * @Author qinxiang
 * @Date 2022/11/23-上午11:10
 * 如何统计一行字符中有多少个单词
 */
public class Test4 {
    public static void main(String[] args) {
        String s = "you  are li";
        System.out.println(countWords(s));
    }
    public static int countWords(String s){
        char[] chars = s.toCharArray();
        int count = 1;
        for(int i = 1; i < chars.length; i ++){
            if(chars[i] == ' '){
                if(chars[i - 1] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }
}
