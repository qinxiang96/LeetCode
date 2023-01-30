package com.flora.test.dataStructure;

import java.util.*;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午4:10
 * 如何计算2个有序整数数组的交集
 */
public class ArrayTest10 {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4};
        int[] b = {1,3,5,7,9};
        ArrayList<Integer> mixed = mixed2(a, b);
        for(Integer x:mixed){
            System.out.print(x + " ");
        }
        System.out.println();
        int[] ints = mixed3(a, b);
        for(int i = 0; i < ints.length; i ++) {
            System.out.println(ints[i]);
        }
    }
    //暴力法
    public static ArrayList<Integer> mixed(int a1[], int a2[]){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < a1.length; i ++){
            for(int j = 0; j < a2.length; j ++){
                if(a1[i] == a2[j]){
                    list.add(a1[i]);
                    break;
                }
            }
        }
        return list;
    }
    //方法一：二路归并法
    public static ArrayList<Integer> mixed2(int a1[], int a2[]){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n1 = a1.length;
        int n2 = a2.length;
        while (i < n1 && j < n2){
            if(a1[i] == a2[j]){
                list.add(a1[i]);
                i ++;
                j ++;
            }else if(a1[i] > a2[j]){
                j ++;
            }else if(a1[i] < a2[j]){
                i ++;
            }
        }
        return list;
    }
    //顺序遍历法
    public static int[] mixed3(int a1[], int a2[]){
        int[] res = new int[a1.length + a2.length];
        int k = 0;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for(int j = 0; j < a2.length; j ++){
            hashtable.put(a2[j], 1);
        }
        for(int i = 0; i < a1.length; i ++){
            if(hashtable.containsKey(a1[i])){
                hashtable.put(a1[i], hashtable.get(a1[i]) + 1);
            }else{
                hashtable.put(a1[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hashtable.entrySet();
        for(Map.Entry e:entries){
            if((int)e.getValue() == 2){
                //System.out.println(e.getKey());

                res[k++] = (int)e.getKey();

            }
        }
        return res;


    }

}
