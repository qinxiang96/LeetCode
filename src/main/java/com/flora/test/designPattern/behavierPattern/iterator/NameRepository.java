package com.flora.test.designPattern.behavierPattern.iterator;

/**
 * @Author qinxiang
 * @Date 2022/10/20-下午2:38
 */
public class NameRepository implements Container{
    public String[] names = {"yihao","erhao","sanhao","sihao"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }
    private class NameIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
