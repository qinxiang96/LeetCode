package com.flora.test.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author qinxiang
 * @Date 2022/11/23-上午11:23
 * 如何按要求打印数组的排列情况
 * 问题描述：针对1、2、2、3、4、5这6个数字，写一个函数打印出所有不同的排列，要求4不能在第3位，3和5不能相连
 * 实现步骤：
 * 1、用这6个数字作为6个节点，构造一个无向连通图，除了3与5不连通外，其他所有节点都两两相连
 * 2、分别对这6个节点出发对图的深度优先遍历，每次遍历完所有节点，把遍历的路径对应数字的组合记录下来，若这个数字的第3位不是4，则把这个数字存放到集合set中
 * set集合的特点：元素唯一，不能有重复的元素，因此通过把组合的结果放到set中可以过滤掉重复的组合
 * 3、遍历set集合，打印出集合中的所有结果
 */
public class Test5 {
    public static void main(String[] args){
        Test5 t = new Test5();
        Set<String> set = t.getAllCombination();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    private int[] numbers = new int[]{1,2,2,3,4,5};
    private int n = numbers.length;
    //标记图中节点是否被遍历过
    private boolean[] visited = new boolean[n];
    //图的二维数组表示
    private int[][] gragh = new int[n][n];
    //数字的组合
    private String combination = "";
    public Set<String> getAllCombination(){
        //构造图
        buildGraph();
        //用来存放所有的组合
        Set<String> set = new HashSet<String>();
        //分别从不同的节点出发深度遍历图
        for(int i = 0; i < n; i ++){
            this.depthFirstSearch(i,set);
        }
        return set;
    }
    private void buildGraph(){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(i== j){
                    gragh[i][j] = 0;
                }else{
                    gragh[i][j] = 1;
                }
            }
        }
        //确保在遍历时3和5不可达
        gragh[3][5] = 0;
        gragh[5][3] = 0;
    }
    //对数从节点start位置开始进行深度遍历
    private void depthFirstSearch(int start, Set<String> set){
        visited[start] = true;
        combination += numbers[start];
        if(combination.length() == n){
            //4不出现在第三个位置
            if(combination.indexOf("4") != 2){
                set.add(combination);
            }
        }
        for(int j = 0; j < n; j ++){
            if(gragh[start][j] == 1 && visited[j] == false){
                depthFirstSearch(j, set);
            }
        }
        combination = combination.substring(0,combination.length() - 1);
        visited[start] = false;
    }
}
