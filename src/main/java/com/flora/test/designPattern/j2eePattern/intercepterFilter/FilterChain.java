package com.flora.test.designPattern.j2eePattern.intercepterFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:17
 */
public class FilterChain {
    //private Filter filter;
    private Target target;
    List<Filter> filters = new ArrayList<>();
    public void addFilter(Filter filter){
        filters.add(filter);
    }
    public void executeFilter(String request){
        for (Filter filter:filters){
            filter.execute();
        }
        target.execute(request);
    }
    public void setTarget(Target target){
        this.target = target;
    }


}
