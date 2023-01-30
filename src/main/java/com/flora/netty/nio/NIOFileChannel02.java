package com.flora.netty.nio;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author qinxiang
 * @Date 2023/1/26-下午8:22
 * 将文件读取到控制台
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        //创建文件的输入流
        File file = new File("/Users/qinxiang/Desktop/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取通道
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将通道数据读入到缓冲区
        channel.read(byteBuffer);
        //将字节转成String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }

}
