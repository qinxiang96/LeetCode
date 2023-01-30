package com.flora.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author qinxiang
 * @Date 2023/1/26-下午8:53
 * 实例要求：
 *
 * 1. 使用 `FileChannel`（通道）和方法 `read、write`，完成文件的拷贝
 * 2. 拷贝一个文本文件 `1.txt`，放在项目下即可
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/qinxiang/Desktop/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //创建通道
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将通道数据读取到缓存区
        fileChannel.read(byteBuffer);
        fileInputStream.close();
        //读写转换
        byteBuffer.flip();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qinxiang/Desktop/file02.txt");
        FileChannel fileChannel1 = fileOutputStream.getChannel();
        fileChannel1.write(byteBuffer);
        fileOutputStream.close();
    }
}
