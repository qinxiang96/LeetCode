package com.flora.test.dataStructure;

import java.util.Arrays;

/**
 * @Author qinxiang
 * @Date 2022/11/21-下午8:39
 * 如何求绝对值最小的数
 */
public class ArrayTest6 {
    public static void main(String[] args) {
        int[] a = {3,-2,5,7,-3};
        System.out.println(find(a));
        System.out.println(find2(a));
    }
    public static int find(int[] a){
        Arrays.sort(a);
        if(a[0] >=0){
            return a[0];
        }else if(a[a.length - 1] < 0){
            return a[a.length -1];
        }else{
            //数组中既有正数也有负数
            int x = -1;
            int y = -1;
            for(int i = 0; i < a.length; i ++){
                if(a[i] < 0){
                    x ++;
                }else if(a[i] > 0){
                    y = x;
                    y ++;
                }else{
                    return a[i];
                }
            }
            return (-a[x] < a[y])?a[x]:a[y];
        }

    }
    //采用二分法 查找正数与负数的分界点
    //思路：取a[mid]
    //1、a[mid]=0 return a[mid]
    //2、a[mid] > 0 如果a[mid - 1] < 0,分界点就找到了，比较这两个数的绝对值；如果a[mid - 1] = 0 return a[mid - 1]；如果a[mid - 1] > 0 继续向左查找
    //3、a[mid] < 0 如果a[mid + 1] > 0,分界点就找到了，比较这两个数的绝对值；如果a[mid + 1] = 0 return a[mid + 1]；如果a[mid + 1] < 0 继续向右查找
    public static int find2(int[] a){
        if(a == null || a.length < 1){
            return Integer.MIN_VALUE;
        }
        Arrays.sort(a);
        int left = a[0];
        int right = a[a.length - 1];
        while(1==1) {
            int mid = left + (right - left) / 2;//正常是(right+left)/2,数组下标越界异常
            if (a[mid] == 0) {
                return a[mid];
            } else if (a[mid] > 0) {
                if (a[mid - 1] < 0) {
                    return -a[mid - 1] < a[mid] ? a[mid - 1] : a[mid];
                } else if (a[mid - 1] > 0) {
                    right = mid - 1;
                }else{
                    return a[mid - 1];
                }
            }else if(a[mid] < 0){
                if(a[mid + 1] > 0){
                    return -a[mid] < a[mid + 1]?a[mid]:a[mid + 1];
                }else if(a[mid + 1] < 0){
                    left = mid + 1;
                }else{
                    return a[mid + 1];
                }
            }
        }


    }
}
