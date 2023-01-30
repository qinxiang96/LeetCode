package com.flora.test.designPattern.behavierPattern.iterator;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午2:35
 */
public class IteratorDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
