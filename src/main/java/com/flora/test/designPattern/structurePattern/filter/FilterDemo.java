package com.flora.test.designPattern.structurePattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午7:53
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("yihao", "Male", "Single"));
        persons.add(new Person("erhao", "Female", "Single"));
        persons.add(new Person("sanhao", "Male", "Marry"));

        CriteriaMale criteriaMale = new CriteriaMale();
        List<Person> list = criteriaMale.meetCriteria(persons);
        for(Person person:list){
            System.out.println("name:" + person.getName());
            System.out.println("gender:" + person.getGender());
            System.out.println("status:" + person.getMaritalStatus());
        }
        //printMethod(list);//静态方法只能访问静态的方法，因为此时非静态方法还没有创建，非静态的方法通过new的对象进行访问
        FilterDemo filterDemo = new FilterDemo();
        filterDemo.printMethod(list);

    }
    public  void printMethod(List<Person> persons){
        for(Person person:persons){
            System.out.println("name:" + person.getName()+" gender:" + person.getGender()+" status:" + person.getMaritalStatus());
        }
    }
}
