package com.flora.test.designPattern.behavierPattern.visitor;

/**
 * @Author qinxiang
 * @Date 2022/10/21-下午4:02
 */
public class Computer implements ComputerPart{
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(),new Keyboard()};
    }

    @Override
    public void accept(ComputerVisitor computerVisitor) {
        for (int i = 0;i<parts.length;i++){
            parts[i].accept(computerVisitor);
        }
        computerVisitor.visit(this);
    }
}
