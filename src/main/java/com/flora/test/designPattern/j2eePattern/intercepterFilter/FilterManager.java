package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:28
 */
public class FilterManager {
    private FilterChain filterChain;

    public FilterManager(Target target) {

        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }
    public void executeRequest(String request){
        filterChain.executeFilter(request);

    }
}
