package com.flora.test.question;

import java.util.HashSet;

/**
 * @Author qinxiang
 * @Date 2022/12/18-下午10:22
 */
public class Test2 {
    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("aab");
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int num = 1;
        if(s.length() == 0) return 0;
        int flag = -1;
        HashSet<Character> set = new HashSet<>();
        int i;
        for(i = 0; i < s.length(); i ++){
            if(!set.contains(c[i])){
                set.add(c[i]);
                if(i == s.length() - 1 && flag == -1){
                    return set.size();
                }
                if(set.size() == s.length() - flag +1){
                    return set.size();
                }

            }else {
                num = Math.max(num, set.size());
                set.clear();
                flag ++;
                i = flag;

            }
        }
        return num;
    }
}

