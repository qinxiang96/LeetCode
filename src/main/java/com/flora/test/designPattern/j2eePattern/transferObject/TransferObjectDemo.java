package com.flora.test.designPattern.j2eePattern.transferObject;

/**
 * @Author qinxiang
 * @Date 2022/10/23-下午3:30
 */
public class TransferObjectDemo {
    public static void main(String[] args) {
        StudentBO studentBO = new StudentBO();
        for(StudentVO studentVO:studentBO.getAllStudent()){
            System.out.println("name:"+studentVO.getName()+" No:"+studentVO.getRollNo());
        }
        studentBO.addStudent("xixi",2);
        studentBO.deleteStudent(0);
        System.out.println("增删操作后");
        for(StudentVO studentVO1:studentBO.getAllStudent()){
            System.out.println("name:"+studentVO1.getName()+" No:"+studentVO1.getRollNo());
        }
    }
}
