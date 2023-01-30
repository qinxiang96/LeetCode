package com.flora.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author qinxiang
 * @Date 2023/1/27-下午2:07
 * 案例要求：
 *  *
 *  * 1. 编写一个 `NIO` 入门案例，实现服务器端和客户端之间的数据简单通讯（非阻塞）
 *  * 2. 目的：理解 `NIO` 非阻塞网络编程机制
 *  客户端的编写
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 得到网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞模式
        socketChannel.configureBlocking(false);
        // 提供服务器端的IP和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)){
            while(!socketChannel.finishConnect()){
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他工作。。。");
            }
        }
        // 连接成功，发送数据
        String str = "first nio data";
        // wrap 包裹一个byte数组到buffer中
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // 发送数据
        socketChannel.write(buffer);
        System.in.read();
    }
}
