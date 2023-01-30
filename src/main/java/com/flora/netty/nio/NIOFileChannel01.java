package com.flora.netty.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author qinxiang
 * @Date 2023/1/26-下午7:04
 * 1. 使用前面学习后的 `ByteBuffer`（缓冲）和 `FileChannel`（通道），将 "hello,java" 写入到 `file01.txt` 中
 * 2. 文件不存在就创建
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello,java";
        // 创建一个输出流-》channel
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qinxiang/Desktop/file01.txt");
        // 通过fileOutputStream获取对应的FileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();
        // 创建一个缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 将str放到缓冲区
//        byteBuffer.put(new Byte(str));//Exception in thread "main" java.lang.NumberFormatException: For input string: "hello,java"
        byteBuffer.put(str.getBytes());
        //对 byteBuffer 进行 flip
        //如何从buffer读取数据
        // 将buffer转换，读写切换
        byteBuffer.flip();

        //将 byteBuffer 数据写入到 fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
