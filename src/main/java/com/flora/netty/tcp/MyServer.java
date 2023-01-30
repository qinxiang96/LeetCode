package com.flora.netty.tcp;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * TCP 粘包和拆包现象实例
 *
 * 在编写 `Netty` 程序时，如果没有做处理，就会发生粘包和拆包的问题
 *
 * 运行结果：
 * 服务器接收到数据 hello,server 0hello,server 1hello,server 2hello,server 3hello,server 4hello,server 5hello,server 6hello,server 7hello,server 8hello,server 9
 * 服务器接收到消息量=1
 *
 * 服务器接收到数据 hello,server 0
 * 服务器接收到消息量=1
 * 服务器接收到数据 hello,server 1hello,server 2hello,server 3hello,server 4hello,server 5hello,server 6hello,server 7hello,server 8hello,server 9
 * 服务器接收到消息量=2
 */
public class MyServer {
    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new MyServerInitializer()); //自定义一个初始化类


            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
