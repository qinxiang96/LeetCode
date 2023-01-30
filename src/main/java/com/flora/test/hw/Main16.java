package com.flora.test.hw;

import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2022/11/2-上午10:31
 */

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] list = {{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()},{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()},{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()},{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()},{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()}};

        int res = maxValueShop(list, N);
        System.out.println(res);
    }
    public static int maxValueShop(int[][] list, int N){//传入的是一个二维数组 和可用总钱数
        int len = list.length;
        int[] v = new int[len + 1];
        int[] p = new int[len + 1];
        int[] q = new int[len + 1];
        Goods[] goods = new Goods[len + 1];
        for (int i = 1; i < len + 1; i ++){
            v[i] = list[i - 1][0];//list[0][0]代表第一个物品的价格，第0列
            p[i] = list[i - 1][1];//list的第1列，代表重要程度
            q[i] = list[i - 1][2];//list的第2列，代表有无附件
            goods[i] = new Goods(v[i], p[i], q[i]);//用这三个参数进行初始化
        }
        //对附件进行处理，如果该物品是附件，那么将该附件对应到主件上去
        for(int i = 1; i < len + 1; i ++){
            if(goods[i].q > 0){//说明该商品是附件，goods[i].q为附件所属的主件的编号
                if(goods[goods[i].q].a1 == 0){//当前商品的主件的a1为0，说明附件1为空，加到附件1上
                    goods[goods[i].q].setA1(i);//设置附件的编号
                }
                if(goods[goods[i].q].a2 == 0){//说明附件1已经有了，加到附件2上去
                    goods[goods[i].q].setA2(i);
                }
            }
        }
        //dp[i][j]代表的是：手中有j元时，买第i件物品时达到的最大满意度是d[i][j]
        int[][] dp = new int[len + 1][N/10 + 1];
        for(int i = 1; i < len + 1; i ++){
            int price = 0, price1 = 0, price2 = 0, price3 = 0;
            int temp = 0, temp1 = 0, temp2 = 0, temp3 = 0;
            //只考虑主件
            price = goods[i].v;
            //最大满意度的临时值，价格*重要程度
            temp = goods[i].v * goods[i].p;
            //买主件+附件1
            if(goods[i].a1 > 0){//主件的附件的编号
                price1 = goods[goods[i].a1].v + price;
                temp1 = goods[goods[i].a1].v * goods[goods[i].a1].p + temp;
            }
            //买主件+附件2
            if(goods[i].a2 > 0){
                price2 = goods[goods[i].a2].v + price;
                temp2 = goods[goods[i].a2].v * goods[goods[i].a2].p + temp;
            }
            //买主件+附件1+附件2
            if(goods[i].a1 > 0 && goods[i].a2 > 0){
                price3 = goods[goods[i].a1].v + goods[goods[i].a2].v + price;
                temp3 = goods[goods[i].a1].v * goods[goods[i].a1].p + goods[goods[i].a2].v * goods[goods[i].a2].p + temp;
            }
            //对dp进行赋值（填充表格），这里很重要！！！！
            //dp[i][j]代表的是：手中有j元时，买第i件物品时达到的最大满意度是d[i][j]
            for (int j = 1; j < N/10 + 1; j ++){
                if(goods[i].q > 0){//当前是一个附件，不做判断和处理，因为附件已经算到主件购买方案中去了，不能单独购买附件
                    dp[i][j] = dp[i - 1][j];//进行下一个商品的判断
                }else{
                    //只买主件
                    if(j*10 >= price && price != 0){
                        //不买和买了的情况取满意度的最大值
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][(j*10 - price)/10] + temp);
                    }
                    //买主件+附件1
                    if(j*10 >= price1 && price1 != 0){
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][(j*10 - price1)/10] + temp1);
                    }
                    //买主件+附件2
                    if(j*10 >= price2 && price2 != 0){
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][(j*10 - price2)/10] + temp2);
                    }
                    //买主件+附件1+附件2
                    if(j*10 >= price3 && price3 != 0){
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][(j*10 - price3)/10] + temp3);
                    }
                }
            }

        }
        //这里最终返回的就是最后一个值
        return dp[len][N/10];

    }
}
class Goods{
    int v;//价格
    int p;//重要度
    int q;//是否为附件 0  n
    int a1 = 0,a2 = 0;//附件是哪个商品的

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public Goods(int v, int p, int q) {
        this.v = v;
        this.p = p;
        this.q = q;

    }
}
