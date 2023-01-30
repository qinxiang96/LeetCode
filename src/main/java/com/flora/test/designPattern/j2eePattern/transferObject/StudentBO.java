package com.flora.test.designPattern.j2eePattern.transferObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午3:32
 */
public class StudentBO {
    List<StudentVO> students;

    public StudentBO() {
        students = new ArrayList<>();
        StudentVO vo = new StudentVO("zhangsan", 0);
        StudentVO vo1 = new StudentVO("lisi", 1);
        students.add(vo);
        students.add(vo1);
    }
    public List<StudentVO> getAllStudent(){
        return students;
    }
    public StudentVO getStudent(int rollNo){
        return students.get(rollNo);

    }
    public void deleteStudent(int rollNo){
        students.remove(students.get(rollNo));
        System.out.println(students.get(rollNo).getRollNo()+"号 student:"+students.get(rollNo).getName()+" removed");
    }
    public void addStudent(String name, int rollNo){
        StudentVO studentVO = new StudentVO(name, rollNo);
        students.add(studentVO);
    }
    public void updateStudent(StudentVO student){
        students.set(student.getRollNo(),student);
        System.out.println(student.getRollNo()+"号 student:"+students.get(student.getRollNo()).getName()+" updated");

    }
}
