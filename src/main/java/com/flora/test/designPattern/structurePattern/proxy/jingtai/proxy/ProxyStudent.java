package com.flora.test.designPattern.structurePattern.proxy.jingtai.proxy;

import com.flora.test.designPattern.structurePattern.proxy.jingtai.domain.Student;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.service.IStudentService;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.service.impl.StudentServiceImpl;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.transaction.DaoTransaction;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午12:22
 */
public class ProxyStudent implements IStudentService {
    // 将被代理的类传进来 目标类对象
    private StudentServiceImpl studentService;
    // 将事务拓展类传进来 增强类对象
    private DaoTransaction transaction;
    // 属性是空的，通过构造器传进来
    public ProxyStudent(IStudentService studentService,DaoTransaction transaction){
        this.studentService = (StudentServiceImpl) studentService;
        this.transaction = transaction;
    }
    public void save() {
        transaction.before();
        studentService.save();
        transaction.after();

    }

    public Student query(Long id) {
        return studentService.query(id);
    }
}
