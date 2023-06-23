package com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB;

import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.interceptor.CglibInterceptor;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.service.IStudentService;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.service.impl.StudentServiceImpl;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.CGLIB.transaction.DaoTransaction;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @Author qinxiang
 * @Date 2023/6/23-下午10:36
 */
public class TestCglib {
    @Test
    public void testCglib(){
        // 生成目标代理类文件-仅用于分析
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/qinxiang/Documents/LeetCode/src/main/java/com/flora/test/designPattern/structurePattern/proxy/dongtai/CGLIB/");
        // 得到方法拦截器
        CglibInterceptor cglibInterceptor = new CglibInterceptor(new DaoTransaction());
        // 使用CGLIB框架生成目标类的子类（代理类）实现增强
        Enhancer enhancer = new Enhancer();
        // 设置父类字节码
        enhancer.setSuperclass(StudentServiceImpl.class);
        // 设置拦截处理
        enhancer.setCallback(cglibInterceptor);
        IStudentService proxyStudentService = (IStudentService) enhancer.create();
        proxyStudentService.save();// 执行结果： 开启事务 保存学生信息 关闭事务

    }
}
