package com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK;


import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.handler.TransactionHandler;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.service.IStudentService;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.service.impl.StudentServiceImpl;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.transaction.DaoTransaction;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;


/**
 * @Author qinxiang
 * @Date 2023/6/23-上午1:24
 */
public class TestStudent {
    @Test
    public void testStudent() throws Throwable {
        // 目标执行类
        IStudentService studentService = new StudentServiceImpl();
        // 增强类对象-对应前置通知和后置通知
        DaoTransaction daoTransaction = new DaoTransaction();
        // 方法拦截处理器
        TransactionHandler transactionHandler = new TransactionHandler(daoTransaction, studentService);
        // 获取代理实例对象-对应静态代理中的ProxyStudent类
        IStudentService proxyInstance = (IStudentService) Proxy.newProxyInstance(StudentServiceImpl.class.getClassLoader(), StudentServiceImpl.class.getInterfaces(), transactionHandler);

        //transactionHandler.invoke(proxyInstance,StudentServiceImpl.class.getMethod("save"),null);
        proxyInstance.query(1L);
        saveProxyClass("/Users/qinxiang/Documents/LeetCode/src/main/java/com/flora/test/designPattern/structurePattern/proxy/dongtai/JDK/file");


    }

    /**
     * 获取创建代理类的字节码文件
     * @param path
     */
    private void saveProxyClass(String path){
        byte[] $Proxy1s = ProxyGenerator.generateProxyClass("$Proxy1", StudentServiceImpl.class.getInterfaces());
        FileOutputStream out = null;
        try {
             out = new FileOutputStream(new File(path + "$Proxy1.class"));
             out.write($Proxy1s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
