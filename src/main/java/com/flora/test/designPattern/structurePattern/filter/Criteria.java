package com.flora.test.designPattern.structurePattern.filter;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-下午8:02
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
