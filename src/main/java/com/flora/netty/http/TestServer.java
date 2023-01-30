package com.flora.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author qinxiang
 * @Date 2023/1/28-下午4:12
 * 1. 实例要求：使用 `IDEA` 创建 `Netty` 项目
 * 2. `Netty` 服务器在 `6668` 端口监听，浏览器发出请求 `http://localhost:6668/`
 * 3. 服务器可以回复消息给客户端"Hello!我是服务器5",并对特定请求资源进行过滤。
 * 4. 目的：`Netty` 可以做 `Http` 服务开发，并且理解 `Handler` 实例和客户端及其请求的关系。
 *
 * 注意：用浏览器访问，由于浏览器设置了允许访问的端口，所以6668一般不可直接访问，试试8080，正常访问
 */
public class TestServer {
    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new TestServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();

            channelFuture.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
