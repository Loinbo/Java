package com.bit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2019/3/8
 * TIME:21:02
 */

public class SingleClient {

    public static void main(String[] args) throws IOException {

        String serverName = "127.0.0.1";
        Integer port = 4399;
        try {
            //1.创建客户端socket连接服务器
            Socket socket = new Socket(serverName, port);
            System.out.println("已连接上服务器，服务器地址为：" + socket.getInetAddress());

            //2.1发送数据
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write("你好服务器\n");
            writer.flush();

            //2.2接收数据
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String message = scanner.nextLine();
            System.out.println("接收到服务器消息:"+message);

            //3.关闭Socket
            socket.close();

        }catch(IOException e){
            System.out.println("客户端通信出现异常，错误为："+e);
        }
    }
}
