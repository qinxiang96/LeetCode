package com.flora.test.hw.nowcoder;

import java.util.*;

/**
 * @Author qinxiang
 * @Date 2023/6/18-下午6:34
 */
public class DelLest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int count = 0;
            HashSet<Character> set = new HashSet<>();
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for (int i = 0; i < str.length(); i ++){

                if (set.contains(chars[i])){
                    map.put(chars[i],++count);
                    continue;
                }
                set.add(chars[i]);
                count = 0;
                map.put(chars[i],++count);
            }
            Collection<Integer> values = map.values();
            Integer min = Collections.min(values);
            Set<Character> keySet = map.keySet();
            for (Character c : keySet){
                if (map.get(c)==min){
                    str = str.replaceAll(String.valueOf(c),"");
                }
            }
            System.out.println(str);
        }
    }
}
