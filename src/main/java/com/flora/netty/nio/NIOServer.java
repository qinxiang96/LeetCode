package com.flora.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author qinxiang
 * @Date 2023/1/27-下午1:20
 * 案例要求：
 *
 * 1. 编写一个 `NIO` 入门案例，实现服务器端和客户端之间的数据简单通讯（非阻塞）
 * 2. 目的：理解 `NIO` 非阻塞网络编程机制
 * 服务器端的编写
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 得到Selector对象
        Selector selector = Selector.open();
        // 绑定端口 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 把ServerSocketChannel注册到Selector,关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 循环等待客户端连接
        while(true){
            if(selector.select(1000) == 0){
                // 没有事件发生
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            // 如果返回的>0，就获取到相关的selectionKey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 遍历Set<SelectionKey>
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                // 获取到SelectionKey
                SelectionKey key = keyIterator.next();
                // 根据key对应的通道发生的事件做响应的处理
                if (key.isAcceptable()){
                    // 如果是OP_ACCEPT，有新的客户端连接，给该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成一个socketChannel:"+socketChannel.hashCode());
                    // 设置为非阻塞 否则会报异常Exception in thread "main" java.nio.channels.IllegalBlockingModeException
                    socketChannel.configureBlocking(false);
                    // 将socketChannel也注册到Selector,关心事件为OP_READ,关联一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()){
                    // 如果是OP_READ，通过key反向获取到对应的channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("form 客户端："+ new String(buffer.array()));
                }
                // 手动从集合中移除当前的selectionKey，防止重复遍历操作
                keyIterator.remove();
            }
        }
    }
}
