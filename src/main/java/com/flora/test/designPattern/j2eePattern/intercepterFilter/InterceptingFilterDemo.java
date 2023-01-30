package com.flora.test.designPattern.j2eePattern.intercepterFilter;

/**
 * @Author qinxiang
 * @Date 2022/10/23-上午11:09
 */
public class InterceptingFilterDemo {

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
//        filterManager.executeRequest("show");
        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("show");
    }
}
