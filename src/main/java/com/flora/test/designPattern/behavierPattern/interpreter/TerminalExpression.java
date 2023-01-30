package com.flora.test.designPattern.behavierPattern.interpreter;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午12:01
 */
public class TerminalExpression implements Expression{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
