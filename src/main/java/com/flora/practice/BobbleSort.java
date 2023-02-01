package com.flora.practice;

/**
 * @Author qinxiang
 * @Date 2023/2/1-下午10:03
 * 冒泡排序
 * 首先理解什么是冒泡排序
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *
 * 针对所有的元素重复以上的步骤，除了最后一个。
 *
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 其次，找规律
 * 5个数比
 * 一共比4轮
 * 第1轮 比较4次
 * 第2轮，比较3次
 * 。。。
 * 第4轮，比较1次
 *
 * 总结：
 * 轮数：for (int i = 1;i < a.length; i ++){
 * 每轮的次数：for (int j = 0; j < a.length - i; j ++){
 * 每次比较的下标：j 和 j + 1
 *
 */
public class BobbleSort {
    public static void main(String[] args) {
        int[] a = {2,4,1,3,5};
        int[] res = bobbleSort(a);
        for (int i = 0; i < res.length; i ++){
            System.out.println(res[i]);
        }
    }
    // 写成一个方法
    public static int[] bobbleSort(int[] a){
        for (int i = 1;i < a.length; i ++){
            for (int j = 0; j < a.length - i; j ++){
                if (a[j] > a[j + 1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }

}
