package com.flora.test.hw.string;

/**
 * @Author qinxiang
 * @Date 2022/11/23-上午10:14
 * 如何删除字符串中重复的字符
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(removeDuplicate2("aabdff"));
    }
    public static String removeDuplicate(String s){
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++){
            for(int j = i + 1; j < chars.length; j ++){
                if(chars[j] == ' '){
                    continue;
                }
                if(chars[i] == chars[j]){
                    chars[j] = ' ';
                }
            }
        }
        //去掉空格
        int l = 0;
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] != ' '){
                chars[l ++] = chars[i];
            }
        }
        return new String(chars,0,l);
    }
    //正则表达式法
    public static String removeDuplicate2(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        s = stringBuffer.reverse().toString();
        System.out.println(s);
        s = s.replaceAll("(?s)(.)(?=.*\\1)","");//这里处理后要记得赋值，s本身是不变的
        System.out.println(s);
        StringBuffer stringBuffer2 = new StringBuffer(s);
        s = stringBuffer2.reverse().toString();
        return s;
    }

}
