package com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.handler;


import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.transaction.DaoTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午1:07
 * 实现InvocationHandler接口
 */
public class TransactionHandler implements InvocationHandler {
    // 增强类对象
    private DaoTransaction transaction;
    // 需要被代理的目标对象
    private Object obj;
    public TransactionHandler(DaoTransaction transaction,Object obj){
        this.transaction = transaction;
        this.obj = obj;
    }
    // proxy 代理实例 通过newProxyInstance()创建代理实例
    // Method 执行目标方法 通过invoke()方法执行
    // args 参数数组
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        // 判断当前方法是否是save方法，是才做事务拦截
        if ("save".equals(method.getName())){
            transaction.before();
            ret = method.invoke(obj,args);
            transaction.after();
        }else {
            ret = method.invoke(obj,args);
        }
        return ret;
    }
}
