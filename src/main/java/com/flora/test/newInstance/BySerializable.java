package com.flora.test.newInstance;

import java.io.*;

/**
 * @Author qinxiang
 * @Date 2022/10/24-下午8:57
 */
public class BySerializable implements Serializable {
    public static void main(String[] args) {
        BySerializable bySerializable = new BySerializable();
        try {
            //输出流
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file03"));
            oos.writeObject(bySerializable);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("/Users/qinxiang/Desktop/file03.txt");
        try {
            //输入流
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            BySerializable o = (BySerializable) objectInputStream.readObject();
            o.add(4,4);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void add(int a, int b){
        int c = a + b;
        System.out.println("a+b="+c);
    }
}
