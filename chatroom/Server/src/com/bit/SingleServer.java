package com.bit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2019/3/8
 * TIME:21:23
 */

public class SingleServer {

    public static void main(String[] args) throws IOException {

        //1.创建服务器Socket,端口号为4399
        ServerSocket serverSocket = new ServerSocket(4399);
        System.out.println("等待客户端连接....");

        //2.等待客户端连接，有连接则显示客户端的Socket对象，否则线程阻塞
        Socket socket = serverSocket.accept();
        System.out.println("有客户端连接，端口号为"+socket.getPort());

        //3.1接收数据
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        String message = scanner.nextLine();
        System.out.println("接受到客户端消息:"+message);

        //3.2发送数据
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write("你好客户端\n");
        writer.flush();

        //4.关闭Socket
        socket.close();
    }
}
