package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:48
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.accept(new ComputerDisplayVisitor());
    }
}
