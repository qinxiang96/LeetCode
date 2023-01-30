package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午12:08
 * 如何求数组中两个元素的最小距离
 */
public class ArrayTest7 {
    public static void main(String[] args){
        int[] a = {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        System.out.println(minDistance(a,4,8));
    }
    public static int minDistance(int[] a, int n1, int n2){
        int x1 = -1;
        int x2 = -1;
        int min = Integer.MIN_VALUE + 1;
        for(int i = 0; i < a.length; i ++){
            if(a[i] == n1){
                x1 = i;
                if(x2 >= 0){
                    min = min(Math.abs(min), Math.abs(x1 - x2));
                }
            }
            if(a[i] == n2){
                x2 = i;
                if(x1 >= 0){
                    min = min(Math.abs(min), Math.abs(x2 - x1));
                }
            }
        }
        return min;
    }
    public static int min(int a, int b){
        return a < b?a:b;
    }
}
