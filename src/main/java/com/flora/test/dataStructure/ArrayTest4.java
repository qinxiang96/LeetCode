package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/21-下午3:04
 * 如何用递归方法求一个整数数组的最大元素
 */
public class ArrayTest4 {
    public static void main(String[] args) {
        int[] a = {2,23,45,2,4};
        System.out.println(findMax(a));
        System.out.println(findMax2(a,0));
    }
    public static int findMax(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i ++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
    //递归方法
    //递归的求解数组第一个元素与 数组中其他元素组成的子数组的最大值 的最大组
    public static int findMax2(int[] a, int begin){

        int length = a.length - begin;
        if(length == 1){
            return a[begin];
        }else{
            return max(a[begin], findMax2(a,begin + 1));
        }

    }
    public static int max(int x, int y){
        return x > y?x:y;
    }
}
