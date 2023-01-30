package com.flora.test.designPattern.structurePattern.filter;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:22
 */
public class AndCriteria implements Criteria{

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstList = criteria.meetCriteria(persons);
        List<Person> list = otherCriteria.meetCriteria(firstList);
        return list;
    }
}
