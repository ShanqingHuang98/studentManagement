package com.hsq.client;


import com.hsq.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author concise
 */
public class Client2 {
    //https://www.cnblogs.com/jing99/p/12000371.html

    public static void client2() throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("客户端2启动");
        PrintStream out;
        BufferedReader in;

        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String uname = "黄山青";
        String upass = "1998huang";
        User user = new User(uname, upass);

        while (true) {
            for (int i = 0; i < 5; i++) {
                Thread thread = new Thread();
                thread.start();
                System.out.println("第" + i + "个客户端2的线程");
                out.println(user);
                System.out.println("客户端发送2：" + user);
                String reply = in.readLine();
                System.out.println("服务器回复 :" + reply);
            }
        }
//        socket.close();
    }

}