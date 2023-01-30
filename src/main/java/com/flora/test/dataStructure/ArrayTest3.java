package com.flora.test.dataStructure;

import java.util.Arrays;

/**
 * @Author qinxiang
 * @Date 2022/11/21-上午10:31
 * 找出数组中只出现一次的数字
 * 前提：只有一个数字出现1次，其他数字出现2次
 * 异或运算 ^ 运算法则相当于不带进位的二进制加法：二进制下用1表示真，0表示假，则异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1）
 * 异或满足交换律和结合律， 且 X＾X ＝ 0， 0 ＾X ＝ X， 则有（A＾B） ＾（ A＾A＾B） ＝ A＾B＾B ＝ A
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        int a[] = {1,2,3,5,4,3,5,4,1};
        System.out.println(findNotDouble(a));
        System.out.println("简单搜索："+find(a));
    }
    public static int find(int[] a){
        Arrays.sort(a);
        for(int i = 0; i < a.length - 1; i = i + 2){
            if(a[i] != a[i + 1]){
                return a[i];
            }
        }
        return a[a.length - 1];
    }
    public static int findNotDouble(int a[]){
        int n = a.length;
        int res = a[0];
        for(int i = 1; i < n; i ++){
            res ^= a[i];
        }
        return res;
    }
    //如果相同数字出现的次数为奇数

}
