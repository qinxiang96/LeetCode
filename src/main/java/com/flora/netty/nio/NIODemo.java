package com.flora.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author qinxiang
 * @Date 2022/10/25-上午11:11
 */
public class NIODemo {
    public static void main(String[] args) {
        try {
            NIODemo.selector();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void selector() throws IOException {
        //先给缓冲区申请内存空间
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //打开Selector为了它可以轮询每个 Channel 的状态
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//设置为非阻塞方式
        ssc.socket().bind(new InetSocketAddress(8080));//绑定一个端口
        ssc.register(selector, SelectionKey.OP_ACCEPT);//将selector对象注册到ssc，注册监听的事件SelectionKey.OP_ACCEPT
        while (true) {
            Set selectedKeys = selector.selectedKeys();//取得所有key集合，一个selectedKey表示一个到达的事件
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {//说明是新的客户端接入
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssChannel.accept();//接受到服务端的请求
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);//注册 更改
                    it.remove();//把当前的selectedKey移除，表示完成
                } else if
                ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {//读取数据的事件状态，调用读取数据的机制
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true) {
                        buffer.clear();
                        int n = sc.read(buffer);//读取数据
                        if (n <= 0) {
                            break;
                        }
                        buffer.flip();
                    }
                    it.remove();
                }
            }
        }
    }
}

