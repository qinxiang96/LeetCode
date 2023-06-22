package com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.service.impl;


import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.domain.Student;
import com.flora.test.designPattern.structurePattern.proxy.dongtai.JDK.service.IStudentService;

/**
 * @Author qinxiang
 * @Date 2023/6/23-上午12:16
 */
public class StudentServiceImpl implements IStudentService {
    public void save() {
        System.out.println("保存学生信息");
    }

    public Student query(Long id) {
        System.out.println("查询操作");
        Student student = new Student();
        student.setAge(18);
        student.setName("qinxiang");
        return student;
    }
}
