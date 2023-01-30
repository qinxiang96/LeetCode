package com.flora.netty.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author qinxiang
 * @Date 2023/1/26-下午4:35
 * 实例说明：
 *
 * 1. 使用 `BIO` 模型编写一个服务器端，监听 `6666` 端口，当有客户端连接时，就启动一个线程与之通讯。
 * 2. 要求使用线程池机制改善，可以连接多个客户端。
 * 3. 服务器端可以接收客户端发送的数据（`telnet` 方式即可）。
 *
 * 操作：启动程序 打开cmd 执行telnet 127.0.0.1 6666 连接到一个客户端 可以开始发数据了
 * 输入^] 输入send escape 可以开始发数据了
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池机制
        //思路：
        // 1、创建一个线程池
        // 2、如果有客户连接就创建一个线程，与之通讯
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true){
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("等待连接。。。");
            System.out.println("连接到一个客户端");
            // 就创建一个线程，与之通讯
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 可以和客户端通讯
                    handler(socket);

                }
            });
        }

    }
    //编写一个handler方法，和客户端通讯
    public static void handler(Socket socket){
        try {
            System.out.println("线程："+Thread.currentThread().getId()+"名称："+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            // 通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            // 循环读取客户端发送的数据
            while (true){
                int read = inputStream.read(bytes);
                System.out.println("等待输入。。。");
                System.out.println("线程："+Thread.currentThread().getId()+"名称："+Thread.currentThread().getName());
                if (read != -1){
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
