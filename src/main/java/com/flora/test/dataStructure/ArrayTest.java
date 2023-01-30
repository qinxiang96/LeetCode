package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/20-上午10:28
 * 如何把一个数组循环右移K位
 * 1,2,3,4,5,6,7,8=>7 8 1 2 3 4 5 6
 */
public class ArrayTest {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8};
        shift_k(a,2);
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
    }

    public static void reverse(int a[], int b, int e){
        for(;b < e; b ++, e --){
            int temp = a[e];
            a[e] = a[b];
            a[b] = temp;
        }
    }
    public static void shift_k(int[] a, int k) {
        int n = a.length;
        k = k % n;//为了防止k比n大，右移k位比右移k%n位的结果是一样的
        reverse(a,n - k, n - 1);
        reverse(a,0, n - k -1);
        reverse(a,0,n - 1);
    }

}
