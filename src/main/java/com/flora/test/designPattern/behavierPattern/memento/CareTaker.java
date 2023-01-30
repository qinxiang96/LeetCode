package com.flora.test.designPattern.behavierPattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午4:03
 */
public class CareTaker {
    List<Memento> mementoList = new ArrayList<>();//用于保存Memento,增加add或者根据索引得到get
    public void add(Memento m){
        mementoList.add(m);
    }
    public Memento get(int index){
        return mementoList.get(index);
    }
}
