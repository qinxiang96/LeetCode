package com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.interceptor;

import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.transaction.DaoTransaction;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.service.IStudentService;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author qinxiang
 * @Date 2023/6/23-下午10:23
 */
public class CglibInterceptor implements MethodInterceptor {
    private DaoTransaction transaction;
    public CglibInterceptor(DaoTransaction transaction){
        this.transaction = transaction;
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        transaction.before();
        Object ret = methodProxy.invokeSuper(o, objects);
        transaction.after();
        return ret;
    }
}
