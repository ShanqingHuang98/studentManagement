package com.hsq.client;


import com.alibaba.fastjson.JSON;
import com.hsq.bean.User;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


/**
 * @author concise
 */
public class Client {


    public static void client() throws IOException {
        // 创建两个socket，想让它们先后与server连接
        Socket socket = new Socket("localhost", 8080);
        System.out.println("客户端启动");
        PrintStream out;
        BufferedReader in;

        // in和out好像都是socket的ip和端口
        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        User user = new User();
        user.setUname("黄山青");
        user.setUpass("1998huang");
        String jsonUser = JSON.toJSONString(user);

        while (true) {
            for (int i = 0; i < 4; i++) {
                Thread thread = new Thread();
                thread.start();
                System.out.println("第" + i + "个线程");
                out.println(jsonUser);
                System.out.println("客户端发送：" + user);
                String reply = in.readLine();
                System.out.println("服务器回复 :" + reply);
            }


        }
//        socket.close();
    }

}