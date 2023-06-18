package com.flora.test.hw.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/6/17-下午5:54
 * 注意：有两种情况
 * 一、输入所有的行，输入0后，一起输出结果，这时候就需要将结果先存在一个list中，最后遍历输出
 * 二、一行输入一行输出，输入0后终止当前程序
 */
public class InputAndOutputTest1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> output = new ArrayList<>();
//        while(in.hasNextLine()){
//
//            int n = in.nextInt();
//            if(n == 0){
//                break;
//            }
//            int sum = 0;
//            for(int i = 0;i < n; i ++){
//                sum = sum + in.nextInt();
//            }
//            output.add(sum);
//
//
//        }
//        for (int j = 0;j < output.size(); j ++){
//            System.out.println(output.get(j));
//        }
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            String[] numArr = str.split(" ");
//            if(Integer.parseInt(numArr[0])==0){
//                break;
//            }
//            int sum=0;
//
//            for(int i=1;i<numArr.length;i++){
//                sum+=Integer.parseInt(numArr[i]+"");
//            }
//            System.out.println(sum);

        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int n = in.nextInt();
            String[] strs = in.nextLine().split(" ");
            Arrays.sort(strs);
            for(int i = 0; i < n - 1; i ++){
                System.out.print(strs[i] + " ");

            }
            System.out.print(strs[n-1]);
        }
    }
}
