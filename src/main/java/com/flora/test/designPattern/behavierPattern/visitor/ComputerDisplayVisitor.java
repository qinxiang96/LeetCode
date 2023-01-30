package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午4:14
 */
public class ComputerDisplayVisitor implements ComputerVisitor{
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("display keyboard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("display mouse");

    }

    @Override
    public void visit(Computer computer) {
        System.out.println("display computer");

    }
}
