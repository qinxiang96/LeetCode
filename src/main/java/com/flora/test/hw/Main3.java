package com.flora.test.hw;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author qinxiang
 * @Date 2022/10/27-下午2:56
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int num  = scan.nextInt();
            TreeSet set = new TreeSet<>();
            while(num > 0){

                set.add(scan.nextInt());
                num --;
            }
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
