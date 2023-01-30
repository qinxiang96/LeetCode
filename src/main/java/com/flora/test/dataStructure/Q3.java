package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/19-上午10:02
 * 排序相关的问题
 */
public class Q3 {
    public static void main(String[] args) {
        int[] a = {5,4,9,8,4,0,1};
        selectSort(a);
        for(int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
        System.out.println("冒泡排序：");
        bubbleSort(a);
        for(int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
    }
    //简单排序
    public static void selectSort(int[] a){
        int i, j, temp = 0, flag = 0;
        int n = a.length;
        for (i = 0; i < n; i++){
            temp = a[i];
            flag = i;
            for(j = i + 1; j < n; j++){
                if(a[j] < temp){
                    temp = a[j];
                    flag = j;
                }
            }
            if(flag != i){
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }
    //插入排序
    public static void insertSort(int[] a){
        if(a!=null){
            for (int i = 1; i < a.length;i ++){//初始时假设第一个记录自成一个有序序列，从第二个数开始处理
                int temp = a[i];//记录当前处理的数
                int j = i;//记录当前处理的数的下标
                if(a[j - 1] > temp){//如果前面的数比当前处理的数大
                    while(j >= 1 && a[j -1] > temp){//条件当前面的数比当前处理的数大，且j>=1
                        a[j] = a[j - 1];//将前面的数调整到后一个的位置
                        j --;//继续向前进行处理
                    }
                }
                a[j] = temp;//将当前处理的数放在找到的位置
            }
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] a){
        for(int i = 0; i < a.length - 1; i ++){
            for(int j = 0; j < a.length - 1 - i; j ++){
                if(a[j] < a[j + 1]){//从大到小
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //归并排序
    public static void Merge(int array[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        //TODO
    }
}
