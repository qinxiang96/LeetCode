package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/7-下午3:24
 * 描述
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 *
 * 设KK位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_KT
 * 1
 * ​
 *  ,T
 * 2
 * ​
 *  ,…,T
 * K
 * ​
 *   ，若存在i(1\leq i\leq K)i(1≤i≤K) 使得T_1<T_2<......<T_{i-1}<T_iT
 * 1
 * ​
 *  <T
 * 2
 * ​
 *  <......<T
 * i−1
 * ​
 *  <T
 * i
 * ​
 *   且 T_i>T_{i+1}>......>T_KT
 * i
 * ​
 *  >T
 * i+1
 * ​
 *  >......>T
 * K
 * ​
 *  ，则称这KK名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 *
 * 数据范围： 1 \le n \le 3000 \1≤n≤3000
 *
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 复制
 * 输出：
 * 4
 */
public class Main24 {
    //其实就是求最长递增子序列。动态规划法
    // 1、先找到每一个位置i左侧的最长上升子序列长度left[i]
    // 2、再找到每一个位置i右侧的最长下降子序列长度right[i]
    // 3、然后求出所有位置的最长序列长度=左侧最长子序列长度+右侧最长子序列长度-1（因为该位置被算了两次，所以减1）
    // 4、然后用数目减去最长序列长度就是答案，需要出队的人数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count = scanner.nextInt();
            int[] ints = new int[count];
            for (int i = 0; i < count; i ++){
                ints[i] = scanner.nextInt();
            }
            int right[] = new int[count];
            int left[] = new int[count];
            //计算每个位置左边的最长递增
            for(int i = 0; i < count; i ++){
                left[i] = 1;
                for(int j = 0; j < i; j ++){
                    if(ints[i] > ints[j]){
                        left[i] = Math.max(left[i],left[j] + 1);
                    }
                }

            }
            //计算每个位置右边的最长递减
            for(int i = count - 1; i >= 0; i --){
                right[i] = 1;
                for(int j = count - 1;j > i; j --){
                    if(ints[i] > ints[j]){
                        right[i] = Math.max(right[i], right[j] + 1);
                    }
                }
            }
            //记录每个位置的值
            int[] v = new int[count];
            for(int i = 0; i < count; i ++){
                v[i] = left[i] + right[i] - 1;
            }
            //找到最大的满足要求的值
            int res = 1;
            for(int i = 0; i < count; i ++){
                res = Math.max(res, v[i]);
            }
            System.out.println(count - res);


        }

    }
}
