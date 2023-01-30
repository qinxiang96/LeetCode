package com.flora.test.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/8-下午7:45
 */
public class Main25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x = in.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(0,1);
            for(int i = 1; i < x%(10^9 + 7); i ++){
                if(i%2 == 1){
                    list.add(i, list.get(i - 1) + 1);
                }else if(i%2 == 0){
                    list.add(i,list.get(i - 1)*2);
                }
            }
            int res = list.get(x - 1);
            System.out.println(res);
        }
    }
}
