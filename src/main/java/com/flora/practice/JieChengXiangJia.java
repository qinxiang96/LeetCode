package com.flora.practice;

/**
 * @Author qinxiang
 * @Date 2023/2/1-下午10:49
 * 阶乘相加
 * 首先理解什么是阶乘相加
 * N!+（N-1）!+(N-2)!.....1
 * 其次找规律
 * N=4
 * 4个结果相加
 * 第1个 从4乘到1
 * 第2个 从3乘到1
 * 。。。
 * 第4个 1
 * 总结：
 * 个数：for (int i = 1;i < n + 1; i ++){
 * 乘数的个数：for (int j = 1; j < n - i + 2; j ++){
 * 乘数：每次加1的j自乘 循环结束把中间值加到结果中
 *
 */
public class JieChengXiangJia {
    public static void main(String[] args) {
        System.out.println(jj(4));
        System.out.println(jcxj(4));
    }
    public static int jj(int n){
        int res = 0;
        for (int i = 1;i < n + 1; i ++){
            int tmp = 1;
            for (int j = 1; j < n - i + 2; j ++){
                tmp = tmp * j;
            }
            res += tmp;
        }
        return res;
    }
    public static int jcxj(int n){
        int res = 0;
        int tmp = 1;
        for (int i = 1; i <= n; i ++){
            tmp = tmp * i;//这里的结果可以复用
            res = res + tmp;
        }
        return res;
    }
}
