package com.flora.test.designPattern.j2eePattern.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/22-上午11:08
 */
public class StudentDaoImpl implements StudentDao{
    List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<Student>();
        Student student1 = new Student("zhangsan", 1);
        Student student2 = new Student("lisi", 2);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudent() {

        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        for(Student student:students){
            if(student.getRollNo() == rollNo){
                return student;
            }
        }
//        return students.get(rollNo);
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);

    }

    @Override
    public void updateStudent(Student student) {
        for(Student student1:students){
            if(student1.getRollNo() == student.getRollNo()){
                student1.setName(student.getName());
            }
        }

        //students.get(student.getRollNo()).setName(student.getName());
        System.out.println("update"+student.getRollNo()+"号为"+student.getName());
    }
}
