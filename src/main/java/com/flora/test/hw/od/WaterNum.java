package com.flora.test.hw.od;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author qinxiang
 * @Date 2023/6/24-下午6:42
 * 题目：
 * 给定非空字符串s，将该字符串分割成一些子串
 * 使每个子串的ASCII码值的和均为水仙花数
 *
 * 若分割不成功则返回0
 * 若分割成功且分割结果不唯一 则返回-1
 * 若分割成功且分割结果唯一 则返回分割后子串的数目
 *
 * 解题思路：
 * 通过输入一个字符串来寻找水仙数。水仙数是指一个三位数，它的各位数字的立方和等于它本身。
 * 程序首先定义了一个链表resultLinklist来储存找到的结果，
 * 然后定义了一个方法isWaterNum来判断一个数是否为水仙数，
 * 又定义了一个方法getStringAsciiSum来计算一个字符串中每个字符对应的ASCII码值之和。
 * 接下来是findData方法，它使用递归的方式来寻找符合条件的数。
 * 该方法将输入字符串分割成两个子串subStrOne和subStrTwo，并检查这两个子串的ASCII码值之和是否为水仙数。
 * 如果都是，则将其加入resultLinklist中；如果只有subStrOne是水仙数，则继续在subStrTwo上调用findData方法；
 * 如果都不是，则跳过当前循环。
 * 最后，在main方法中读取用户输入的字符串，调用findData方法处理，并输出结果。
 * 主要使用的Java集合是LinkedList。知识点包括字符串操作、递归、流程控制语句等。
 *
 * 思考：为什么选linkedList作为数据存储结构，arrayList行不行?
 * 答案是可以，但是本题中不需要频繁访问元素，而是向数组中插入元素，使用LinkedList更好
 * LinkedList 类采用链表结构保存对象，这种结构的优点是便于向集合中插入或者删除元素。
 * 需要频繁向集合中插入和删除元素时，使用 LinkedList 类比 ArrayList 类效果高，
 * 但是 LinkedList 类随机访问元素的速度则相对较慢。这里的随机访问是指检索集合中特定索引位置的元素。
 *
 */
public class WaterNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            if (s == null || s.length() == 0){
                return;
            }
            int count = 2;
            findData(s,count);
            int ret = 0;
            if (resultLinkedList.size() > 1){
//            if (1<resultLinkedList.size()){
                ret = -1;
            }else if (resultLinkedList.size() == 1){
                ret = resultLinkedList.get(0);
            }
            System.out.println(ret);
            // 每次输入判断并输出执行完毕后，将list清空，否则会累积
            resultLinkedList.clear();
        }

    }
    public static LinkedList<Integer> resultLinkedList = new LinkedList<>();

    /**
     * 判断一个数是否为水仙数
     * @param s
     */
    public static boolean isWaterNum(String s){
        int num = getStringAsciiSum(s);
        int a = num / 100;
        int b = num / 10 % 10;
        int c = num % 10;
        return a*a*a+b*b*b+c*c*c == num;

    }

    /**
     * 计算一个字符串中每个字符对应的ASCII码值之和
     */
    public static int getStringAsciiSum(String s){
        int result = 0;
        for (char c : s.toCharArray()){
            result += c;
        }
        return result;

    }

    /**
     * 使用递归的方式来寻找符合条件的数
     */
    public static void findData(String s,int number){
        String subStrOne;
        String subStrTwo;
        for (int i = 1;i < s.length(); i ++){
            subStrOne = s.substring(0,i);
            subStrTwo = s.substring(i);
            if (isWaterNum(subStrOne)){
                if (isWaterNum(subStrTwo)){
                    resultLinkedList.add(number);
                }else {
                    findData(subStrTwo,number++);
                }
            }
        }
    }

}
