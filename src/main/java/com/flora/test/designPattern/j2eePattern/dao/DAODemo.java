package com.flora.test.designPattern.j2eePattern.dao;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/22-上午10:57
 */
public class DAODemo {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> allStudent = studentDao.getAllStudent();
        for(Student student:allStudent){
            System.out.println("学生编号："+student.getRollNo()+" 姓名："+student.getName());
        }
        Student student0 = studentDao.getAllStudent().get(0);
//        Student student0 = studentDao.getStudent(1);
        student0.setName("xixi");
        studentDao.updateStudent(student0);
        Student student1 = studentDao.getStudent(1);
        System.out.println("学生编号："+student1.getRollNo()+" 姓名："+student1.getName());

        for(Student student2:allStudent){
            System.out.println("学生编号："+student2.getRollNo()+" 姓名："+student2.getName());
        }
        Student daoStudent = studentDao.getStudent(2);
        studentDao.deleteStudent(daoStudent);
        for(Student student3:allStudent){
            System.out.println("删除后，学生编号："+student3.getRollNo()+" 姓名："+student3.getName());
        }

    }
}
