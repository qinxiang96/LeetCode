package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:48
 */
public interface ComputerPart {
    public void accept(ComputerVisitor computerVisitor);
}
