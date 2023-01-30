package com.flora.test.dataStructure;

import java.util.Arrays;

/**
 * @Author qinxiang
 * @Date 2022/9/29-下午12:02
 */
public class test2 {
    public static void main(String[] args) {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        int res = findTheDistanceValue(arr1, arr2, d);
        System.out.println(res);
    }
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
//        int res = arr1.length;
//        for(int i = 0; i < arr1.length; i ++){
//            for(int j = 0; j < arr2.length; j ++) {
//                if (Math.abs(arr1[i] - arr2[j]) <= d){
//                    res -= 1;
//                    break;
//                }
//            }
//        }
//        return res;
        //方法二：二分法
        //将数组升序排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //定义结果变量
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            int min = arr1[i] - d;
            int max = arr1[i] + d;
            //arr2不存在[min,max]的元素
            if (arr2[0] > max || arr2[arr2.length - 1] < min) {
                ans++;
                continue;
            }
            int left = 0;
            int right = arr2.length - 1;
            boolean inRegion = false;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (arr2[middle] >= min && arr2[middle] <= max) {
                    inRegion = true;
                    break;
                } else if (arr2[middle] < min) {
                    left = middle + 1;
                } else if (arr2[middle] > max) {
                    right = middle - 1;
                }
            }
            if (!inRegion) {
                ans++;
            }
        }
        return ans;
    }
}
