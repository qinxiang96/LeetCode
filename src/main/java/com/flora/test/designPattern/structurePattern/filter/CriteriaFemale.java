package com.flora.test.designPattern.structurePattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:15
 */
public class CriteriaFemale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<>();
        for (Person person: persons){
            if (person.getGender().equalsIgnoreCase("Female")){
                list.add(person);
            }
        }
        return list;
    }
}
