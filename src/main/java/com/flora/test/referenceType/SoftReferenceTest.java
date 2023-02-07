package com.flora.test.referenceType;

import java.lang.ref.SoftReference;

/**
 * @Author qinxiang
 * @Date 2023/2/5-下午3:04
 * 软引用
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        User user = new User(1, "xixi");
        SoftReference<User> user1 = new SoftReference<User>(user);
        user = null;
        // 垃圾回收
        System.gc();
        System.out.println(user1);// java.lang.ref.SoftReference@6e0be858
        // 从软引用中重新获取强引用
        System.out.println(user1.get());// User{id=1, name='xixi'}


        // 模拟内存不足
        try {
            byte[] bytes = new byte[1024 * 1024 * 7];// 当前设置-Xms10M -Xmx10M -XX:+PrintGCDetails
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(user1.get());// null 在报OOM之前，回收了软引用的对象
        }

    }
    public static class User{
        private int id;
        private String name;
        public User(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
