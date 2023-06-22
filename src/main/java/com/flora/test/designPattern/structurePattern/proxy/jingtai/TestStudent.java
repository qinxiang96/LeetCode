package com.flora.test.designPattern.structurePattern.proxy.jingtai;

import com.flora.test.designPattern.structurePattern.proxy.jingtai.domain.Student;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.proxy.ProxyStudent;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.service.impl.StudentServiceImpl;
import com.flora.test.designPattern.structurePattern.proxy.jingtai.transaction.DaoTransaction;
import org.junit.Test;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午12:31
 */
public class TestStudent {
    @Test
    public void testStudent(){
        Student student = new Student();
        StudentServiceImpl studentService = new StudentServiceImpl();
        DaoTransaction daoTransaction = new DaoTransaction();
        ProxyStudent proxyStudent = new ProxyStudent(studentService, daoTransaction);
        proxyStudent.save();
        System.out.println(proxyStudent.query((long) 1));

    }
}
