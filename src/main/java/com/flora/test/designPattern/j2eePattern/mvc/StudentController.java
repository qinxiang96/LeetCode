package com.flora.test.designPattern.j2eePattern.mvc;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午9:36
 */
public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }
    public void setStudentName(String name){
        student.setName(name);
    }
    public String getStudentName(){
        return student.getName();
    }
    public void setStudentNo(int no){
        student.setRollNo(no);
    }
    public int getStudentNo(){
        return student.getRollNo();
    }
    public void updateView(){
        view.printStudentDetail(student.getRollNo(),student.getName());
    }
}
