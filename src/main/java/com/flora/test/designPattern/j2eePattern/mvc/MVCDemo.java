package com.flora.test.designPattern.j2eePattern.mvc;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午9:30
 */
public class MVCDemo {
    public static void main(String[] args) {
        Student model = studentResource();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(model, studentView);
        studentController.updateView();
        studentController.setStudentName("zhangsan");
        studentController.updateView();
    }
    public static Student studentResource(){
        Student student = new Student();
        student.setRollNo(2);
        student.setName("xiangxiang");
        return student;
    }
}
