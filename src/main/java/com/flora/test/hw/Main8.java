package com.flora.test.hw;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author qinxiang
 * @Date 2022/10/31-下午9:07
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 *
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> map= new TreeMap<>();
        int s = scanner.nextInt();
            while (s > 0){
                Integer in = scanner.nextInt();
                if(map.containsKey(in)){
                    int val = map.get(in) + scanner.nextInt();
                    map.put(in, val);
                }else{
                    map.put(in, scanner.nextInt());
                }
                s--;
            }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + " " + value);
        }
    }
}
