package com.flora.test.dataStructure;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author qinxiang
 * @Date 2022/11/21-下午3:49
 * 如何求数对之差的最大值
 */
public class ArrayTest5 {
    public static void main(String[] args) {
        int[] a= {1,23,4};
        System.out.println(findMax(a));
        System.out.println(findMax2(a));
        System.out.println(findMax3(a));
        System.out.println(findMax4(a));
    }
    //蛮力法
    public static int findMax(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length - 1; i ++){
            for(int j = 1; j < a.length; j ++){
                int f = a[i] - a[j];
                if(f > max){
                    max = f;
                }
            }
        }
        return max;
    }
    //优化后，不区分前后数，求两个数差值的绝对值最大
    public static int findMax1(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length - 1; i ++){
            for(int j = 1; j < a.length; j ++){
                int f = a[i] - a[j];
                if(f >=0 && f > max){
                    max = f;
                }
                if(f < 0 && -f > max){
                    max = -f;
                }
            }
        }
        return max;
    }
    //二分法
    //最大差值对应的被减数和减数都在左子树组中，假设最大差值为leftMaxDiff;
    // 都在右子树组中，假设最大差值为rightMaxDiff；
    // 被减数是左子树组的最大值，减数是右子数组中的最小值，假设差值为mixMax
    public static int findMax2(int[] a){
        int max = Integer.MIN_VALUE;
        if(a == null || a.length <= 1){
            return max;
        }
        //为了通过传递引用的方式获取数组的最大值和最小值，使用了AtomicInteger而不是Integer类，
        // 主要原因为Integer类虽然也可以传递引用，但是它是不可变量，在方法内部不能对其进行修改
        //AtomicInteger类：特点：在方法内部可以对其进行修改
        AtomicInteger atomicIntegerMax = new AtomicInteger(0);
        AtomicInteger atomicIntegerMin = new AtomicInteger(0);
        int res = getMaxDiff(a, 0, a.length - 1, atomicIntegerMax, atomicIntegerMin);
        return res;


    }
    public static int getMaxDiff(int[]a, int begin, int end, AtomicInteger max, AtomicInteger min){
        if(begin == end){
            max.set(a[begin]);
            min.set(a[begin]);
            return Integer.MIN_VALUE;
        }
        int mid = begin + (end - begin)/2;
        //数组前半部分的最小值与最大值
        AtomicInteger leftMax = new AtomicInteger(0);
        AtomicInteger leftMin = new AtomicInteger(0);
        //数组前半部分的最大差值
        int leftMaxDiff = getMaxDiff(a, begin, mid, leftMax, leftMin);
        //数组后半部分的最小值与最大值
        AtomicInteger rightMax = new AtomicInteger(0);
        AtomicInteger rightMin = new AtomicInteger(0);
        //数组后半部分的最大差值
        int rightMaxDiff = getMaxDiff(a, mid + 1, end, rightMax, rightMin);
        //第三种情况
        int mixMax = leftMax.get() - rightMin.get();
        //求数组的最大值与最小值
        if (leftMax.get() > rightMax.get()){
            max.set(leftMax.get());
        }else{
            max.set(rightMax.get());
            if(leftMin.get() < rightMin.get()){
                min.set(leftMin.get());
            }else{
                min.set(rightMin.get());
            }
        }
        //求最大的差值
        int allMaxDiff = (leftMaxDiff > rightMaxDiff) ? leftMaxDiff : rightMaxDiff;
        allMaxDiff = (allMaxDiff > mixMax)?allMaxDiff:mixMax;
        return allMaxDiff;
    }
    //方法三：动态规划
    //diff[i]是以数组中第i个数字为减数的所有数对之差的最大值
    //max[i]为前i+1个数的最大值
    //diff[i] = max(diff[i - 1], max[i - 1] - a[i])
    //max[i] = max(max[i - 1], a[i])
    public static int max(int m, int n){
        return (m > n)?m:n;
    }
    public static int findMax3(int[] a){
        int maxDiff = Integer.MIN_VALUE;
        if(a==null || a.length <= 1){
            return maxDiff;
        }
        int[] diff = new int[a.length];
        int[] max = new int[a.length];
        diff[0] = Integer.MIN_VALUE;
        max[0] = a[0];
        for(int i = 1; i < a.length; i ++){
            diff[i] = max(diff[i - 1], max[i - 1] - a[i]);
            max[i] = max(max[i - 1], a[i]);
        }
        return diff[a.length -1];
    }
    //优化：求解diff[i]时，只用到了diff[i-1]与max[i-1]，而与数组diff和max中其他数字无关，
    // 因此可以通过2个变量而不是数组在记录diff[i-1]与max[i-1]的值，从而降低算法的空间复杂度
    public static int findMax4(int[] a){
        int maxDiff = Integer.MIN_VALUE;
        if(a==null || a.length <= 1){
            return maxDiff;
        }
        int diff = 0;
        int max = a[0];
        for(int i = 1; i < a.length; i ++){
            diff = max(diff, max - a[i]);
            max = max(max, a[i]);
        }
        return diff;
    }



}
