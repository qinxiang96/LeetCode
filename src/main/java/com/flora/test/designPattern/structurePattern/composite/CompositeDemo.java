package com.flora.test.designPattern.structurePattern.composite;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午10:28
 * 组合模式
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("yihao", "CEO", "1");
        Employee employee2 = new Employee("erhao", "head develop", "1");
        Employee employee3 = new Employee("sanhao", "head test", "1");
        Employee employee4 = new Employee("sihao", "test", "1");
        Employee employee5 = new Employee("wuhao", "develop", "1");
        Employee employee6 = new Employee("liuhao", "test", "1");

        employee1.add(employee2);
        employee1.add(employee3);
        employee2.add(employee5);
        employee3.add(employee4);
        employee3.add(employee6);

        List<Employee> subordinates = employee3.getSubordinates();
        for (Employee employee:subordinates){
            System.out.println(employee);

        }

    }
}
