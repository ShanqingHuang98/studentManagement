package com.hsq.client;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Client {
    //https://www.cnblogs.com/jing99/p/12000371.html
//    public static void client() throws IOException {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8080);
        boolean connect = channel.connect(socketAddress);
        if (connect) {
            System.out.println("客户端2启动");
        }

        String uname = "老王";
        String upass = "1";

        while (true) {
            for (int i = 0; i < 5; i++) {
                Thread thread = new Thread();
                thread.start();
//                System.out.println("第" + i + "个客户端2的线程");
                String post = uname + "/" + upass;
                byte[] bytes1 = post.getBytes(StandardCharsets.UTF_8);
                if (bytes1 != null && bytes1.length > 0) {
                    ByteBuffer writeBuffer = ByteBuffer.allocate(bytes1.length);
                    writeBuffer.put(bytes1);
                    writeBuffer.flip();
                    channel.write(writeBuffer);
                }

                ByteBuffer readbuffer = ByteBuffer.allocate(1024);
                int readbytes = channel.read(readbuffer);
                if (readbytes > 0) {
                    readbuffer.flip();
                    byte[] bytes = new byte[readbuffer.remaining()];
                    readbuffer.get(bytes);
                    String reply = new String(bytes);
                    System.out.println("服务器回复 :" + reply);
                }
            }
        }
//        socket.close();


    }
}