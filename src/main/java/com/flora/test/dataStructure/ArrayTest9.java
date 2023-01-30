package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午3:22
 * 如何对数组的2个有序段进行合并
 * 数组a[0, mid -1]和a[mid,n-1]是各自有序的，对数组a[0,n -1]的两个子有序段进行合并，得到a[0,n-1]整体有序
 * 实现思路：遍历数组中下标为0~mid - 1的元素，将遍历到的元素的值与a[mid]进行比较，当遍历到a[i]时，如果满足a[mid] <a[i]，那么交换
 * 接着找到交换后的a[mid]在a[mid,num -1]中的具体位置，遍历a[mid~num - 2],如果a[mid+1]<a[mid],那么交换
 */
public class ArrayTest9 {
    public static void main(String[] args) {
        int[] a = {1,5,6,7,9,2,4,8,10,13,14};
        sort(a,5);
    }
    public static void findRightPlaceForMid(int a[], int mid){
        int len = a.length;
        for(int i = mid; i < len - 1;i ++){
            if(a[i + 1] < a[i]){
                int tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;
            }
        }

    }
    public static void sort(int a[], int mid){
        for(int i = 0; i <= mid - 1; i ++){
            if(a[mid] < a[i]){
                int tmp = a[i];
                a[i] = a[mid];
                a[mid] = tmp;
                findRightPlaceForMid(a, mid);
            }
        }

    }
}
