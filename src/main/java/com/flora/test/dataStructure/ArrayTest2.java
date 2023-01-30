package com.flora.test.dataStructure;

import java.util.Arrays;

/**
 * @Author qinxiang
 * @Date 2022/11/20-上午10:54
 * 如何找到数组中第k个最小的数
 */
public class ArrayTest2 {
    public static void main(String[] args){
        int[] a = {1,8,3,4,5,6,7};
        int k = find_k(a, 3);
        System.out.println(k);
        System.out.println("快速排序：");
        int i = quickSort(a, 0, a.length - 1, 5);
        System.out.println(i);
    }
    //方法一：排序法
    public static int find_k(int a[], int k){
        Arrays.sort(a);
        return a[k - 1];
    }
    //方法二:剪枝法
    public static int quickSort(int a[], int low, int high, int k){
        if(low > high){
            return Integer.MIN_VALUE;
        }
        //定义一个变量保存基准数
        int base = a[low];
        //定义变量指向最左边和最右边
        int i = low;
        int j = high;
        //当i和j不相遇的时候，在循环中进行检索
        while(i != j){
            //由j从右往左检索比base小的，如果检索到了就停下
            while(a[j] >= base && i < j){//i<j防止检索越界
                j --;
            }
            //停下，等i从左往右检索比base大的，如果检索到了就停下，此时i位置和j位置互换
            while(a[i] <= base && i < j){
              i ++;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        //如果上面while条件不成立，会跳出循环，说明i和j相遇了
        //交换base和相遇位置的元素
        a[low] = a[i];
        a[i] = base;
        //排基准数左边
        quickSort(a,low,i - 1,k);
        //排基准数的右边
        quickSort(a,i + 1, high,k);
        return a[k - 1];

    }

}
