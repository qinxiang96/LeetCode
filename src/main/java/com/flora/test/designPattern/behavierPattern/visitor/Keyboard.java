package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:50
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerVisitor computerVisitor) {
        computerVisitor.visit(this);
    }
}
