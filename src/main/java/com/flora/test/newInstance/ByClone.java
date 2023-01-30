package com.flora.test.newInstance;

/**
 * @Author qinxiang
 * @Date 2022/10/24-下午6:10
 */
public class ByClone implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        ByClone byClone = new ByClone();
        ByClone clone = (ByClone) byClone.clone();
        clone.add(2,2);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void add(int a, int b){
        int c = a + b;
        System.out.println("a+b="+c);
    }
}
