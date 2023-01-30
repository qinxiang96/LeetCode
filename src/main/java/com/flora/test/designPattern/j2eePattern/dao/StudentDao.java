package com.flora.test.designPattern.j2eePattern.dao;

import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/22-上午11:05
 */
public interface StudentDao {
    public List<Student> getAllStudent();
    public Student getStudent(int rollNo);
    public void deleteStudent(Student student);
    public void updateStudent(Student student);
}
