package com.flora.test.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/12/21-下午2:27
 */
public class demo {
    int idx;

    public static void main(String[] args) {
        System.out.println(objfinally().idx);
        System.out.println(intFinally());
    }

    public static demo objfinally() {
        List<Integer> res = new ArrayList<>();
        demo demo = new demo();
        demo.idx = 20;
        try {
            demo.idx = (int) 10L;
            return demo;
        } catch (NumberFormatException e) {
            demo.idx = 30;
            return demo;
        } finally {
            demo.idx = 40;
        }
    }

    public static int intFinally() {
        List<Integer> res = new ArrayList<>();
        int a = 20;
        try {
            System.out.println(a / 0);
            a = 10;
            return a;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
        }
    }
}
