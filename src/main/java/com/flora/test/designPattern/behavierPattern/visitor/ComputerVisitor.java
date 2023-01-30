package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午3:51
 */
public interface ComputerVisitor {
    public  void visit(Keyboard keyboard);
    public  void visit(Mouse mouse);
    public  void visit(Computer computer);
}
