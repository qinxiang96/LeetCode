package com.flora.practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author qinxiang
 * @Date 2023/2/7-下午11:30
 * 二分查找实现
 * 提供一个目标数组和目标数
 * 返回数组下标
 *
 * 思路：找到数组中间值和目标值比较，如果目标值大于中间值，则继续向右查找
 * 前提是一个有序的数组
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] s1 = {1,4,0,7,9};
        int[] s = s1;
        Arrays.sort(s);
        for (int i = 0; i < s.length; i ++){
            System.out.print(s[i]);
        }
        System.out.println(binarySearch(s,4));
    }
    public static int binarySearch(int[] s, int n){
        int low = 0;
        int high = s.length - 1;
        int mid = (low + high) / 2;
        while(low <= high) {
            if (n > s[mid]) {
                low = mid + 1;
                mid = (low + high) / 2;
            }else if(n < s[mid]){
                high = mid - 1;
                mid = (low + high) / 2;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
