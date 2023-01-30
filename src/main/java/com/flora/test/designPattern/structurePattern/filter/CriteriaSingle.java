package com.flora.test.designPattern.structurePattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:18
 */
public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<>();
        for (Person person: persons){
            if(person.getMaritalStatus().equalsIgnoreCase("Single")){
                list.add(person);
            }
        }
        return list;
    }
}
