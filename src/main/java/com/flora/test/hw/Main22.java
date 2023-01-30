package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/7-上午11:01
 * 描述
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足 1 \le n \le 100 \1≤n≤100
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 * 输入描述：
 * 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
 *
 * 输出描述：
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * 示例1
 * 输入：
 * 3
 * 10
 * 81
 * 0
 * 复制
 * 输出：
 * 1
 * 5
 * 40
 */
public class Main22 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[11];
        for (int i = 0; i < ints.length; i ++){
            ints[i] = Integer.parseInt(scanner.nextLine());
            if(ints[i] == 0){
                break;
            }
            if(i == 10){
                if(ints[i] != 0){
                    System.out.println("测试数据超出限制");
                    break;
                }
            }
        }
        for(int i = 0; i < ints.length; i ++){
            if(ints[i] != 0) {
                System.out.println(ints[i]/2);
            }

        }
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//            int bottle = sc.nextInt();
//            if(bottle==0){
//                break;
//            }
//            System.out.println(bottle/2);
//        }
    }
//    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferedReader.readLine();
//        while (s != null){
//            int x = Integer.parseInt(s);
//            if(x == 0){
//                break;
//            }
//            System.out.println(dd(x));
//        }
//        int[] ints = new int[11];
//        for (int i = 0; i < ints.length; i ++){
//            ints[i] = Integer.parseInt(scanner.nextLine());
//            if(ints[i] == 0){
//                break;
//            }
//            if(i == 10){
//                if(ints[i] != 0){
//                    System.out.println("测试数据超出限制");
//                    break;
//                }
//            }
//        }
//        for(int i = 0; i < ints.length; i ++){
//            if(ints[i] != 0) {
//                int res = dd(ints[i]);
//                System.out.println(res);
//            }
//
//        }
//    }
//    public static int dd(int x){
//        int res = 0;
//        while(x >= 3){
//            res += x / 3;
//            x = x / 3 + x % 3;
//        }
//        if(x == 2){
//            res ++;
//        }
//        return res;
//
////        int a = x / 3;
////        int b = x % 3;
////        int res = a;
////        while(a+b >2) {
////            dd(a + b);
////        }
////        if((a == 1 && b == 1) || b ==2){
////            res += 1;
////        }
////
////        return res;
//
//    }
}
