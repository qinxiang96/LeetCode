package com.flora.test.designPattern.structurePattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/19-上午10:29
 */
public class Employee {
    private String name;
    private String dept;
    private String salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, String salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }
    public void add(Employee employee){
        subordinates.add(employee);
    }
    public void remove(Employee employee){
        subordinates.remove(employee);
    }
    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary='" + salary + '\'' +
                ", subordinates=" + subordinates +
                '}';
    }
}
