package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:57
 */
public class Client {
    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }
    public void sendRequest(String request){
        filterManager.executeRequest(request);
    }
}
