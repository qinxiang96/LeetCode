package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:59
 */
public class Mouse implements ComputerPart{

    @Override
    public void accept(ComputerVisitor computerVisitor) {
        computerVisitor.visit(this);
    }
}
