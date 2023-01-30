package com.flora.test.hw;

import java.util.*;

/**
 * @Author qinxiang
 * @Date 2022/11/7-下午2:41
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 * 复制
 * 输出：
 * aaddd
 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            //统计对应字符的个数
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : chars){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            //找到最小值
            Collection<Integer> values = map.values();
            Integer min = Collections.min(values);
            //将最小值对应的字符替换成空字符串
            Set<Character> characters = map.keySet();
            for(char cc:characters){
                if(map.get(cc)==min){
                    s = s.replaceAll(String.valueOf(cc),"");
                }
            }
            System.out.println(s);

        }
    }
}
