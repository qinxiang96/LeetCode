package com.flora.test.hw;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/6/18-下午12:44
 * 手写十六进制转换成十进制
 */
public class OxToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String x = scanner.next();
            System.out.println(oxToInt(x));
            System.out.println(Integer.parseInt(x.substring(2),16));
        }
    }
    public static int oxToInt(String ox){
        String target = ox.substring(2);
        HashMap<Object,Integer> map = new HashMap<>();
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);
        int convert = 0;
        String a = target.substring(0,1);
        if ( !a.equals("0")){
            convert += map.get(a) * 16;
        }
        String b = target.substring(1,2);
        if (map.get(b) == null){
            convert += Integer.parseInt(b);
        }else {
            convert += map.get(b);
        }
        return convert;
    }
}
