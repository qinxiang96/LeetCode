package com.flora.test.designPattern.structurePattern.filter;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:34
 */
public class OrCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstList = criteria.meetCriteria(persons);
        List<Person> secondList = otherCriteria.meetCriteria(persons);
        for (Person person:firstList){
            if (!secondList.contains(person)){
                secondList.add(person);
            }
        }
        return secondList;
    }
}
