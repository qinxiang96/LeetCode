package com.flora.test.booleanTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2023/9/28-上午7:08
 */
public class BooleanTest {
    public static void main(String[] args) {
        List<Insurant> insurants = new ArrayList<Insurant>();
        Insurant insurant = new Insurant();
        insurant.setName("1");
        insurant.setSex("M");
        Insurant insurant1 = new Insurant();
        insurant1.setSex("F");
        insurant1.setName("2");
        insurants.add(insurant);
        insurants.add(insurant1);
        boolean b = insurants.stream().anyMatch(insurant3 -> insurant3.getName().equals("1"));
        if (b){
            System.out.println(b);
        }
    }

}
