package com.flora.test.designPattern.behavierPattern.interpreter;

/**
 * @Author qinxiang
 * @Date 2022/10/20-上午11:59
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        boolean john = getMaleExpression("john");
        System.out.println("john is a male? " + john);


    }
    public static boolean getMaleExpression(String s){
        TerminalExpression john = new TerminalExpression("john");
        TerminalExpression shone = new TerminalExpression("shone");
        OrExpression orExpression = new OrExpression(john, shone);
        return orExpression.interpret(s);
    }
}
