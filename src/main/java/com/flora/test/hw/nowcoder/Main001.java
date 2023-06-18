package com.flora.test.hw.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/4/6-下午3:59
 */
public class Main001 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(s.hasNext()){
            int z = 0;
            int n = s.nextInt();
            if (n == 0){
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
            int x = n/3;
            int y = n%3;
            z = x;
            if (x + y >1){
                z += (x+ y)/2;
            }
            list.add(z);
        }
    }
}
