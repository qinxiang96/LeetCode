package com.flora.test.designPattern.structurePattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:06
 */
public class CriteriaMale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        ArrayList<Person> list = new ArrayList<>();
        for (Person person: persons){
            if(person.getGender().equalsIgnoreCase("Male")){
                list.add(person);
            }
        }
        return list;
    }
}
