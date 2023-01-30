package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午2:35
 * 如何求指定数字在数组中第一次出现的位置
 * 前提：这个数组中相邻元素之差都为1
 */
public class ArrayTest8 {
    public static void main(String[] args) {
        int[] a = {3,4,5,6,5,6,7,8,9,8};
        System.out.println(find(a,9));
        System.out.println(find2(a,9));

    }
    public static int find(int[] a, int x){
        for(int i = 0; i <a.length; i ++){
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }
    //跳跃搜索法
    //首先用数组中第一个元素3和9进行比较，他们的差值为6，由于数组中相邻2个元素的差值为1，因此9在数组中出现的最早的位置必定为第1+6个位置
    //算法思路：从数组第1个元素开始，把数组当前的位置的值与t进行比较，相等返回数组下标，否则从数组下标为i+|t-a[i]|处继续查找
    public static int find2(int[] a, int x){
        if(a == null || a.length == 0){
            return -1;
        }
        int i = 0;
        while(i < a.length){
            if(a[i] == x){
                return i;
            }else{
                i += Math.abs(x - a[i]);
            }
        }
        return -1;
    }
}
