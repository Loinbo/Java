package ChatRoomServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Loinbo
 * DATE:2019/8/16
 * TIME:14:25
 *
 * 多线程聊天室服务端
 */

public class MulThreadServer {

    public static void main(String[] args) {
        try {
            int port = 6666;
            if (args.length >= 1) {
                try {
                    port = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    port = 6666;
                    System.out.println("指定端口不是有效格式0-65535，采用默认端口" + port);
                }
            }
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器启动" + serverSocket.getLocalSocketAddress());

            //启用线程池，提高线程并发性
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
            //使用 Executors.newFixedThreadPool创建的线程大小是固定的，线程池的基本大小 = 线程池的最大数量，用多少开多少


            while(true){
                Socket client = serverSocket.accept();
                System.out.println("有客户端连接到服务器: " + client.getRemoteSocketAddress());
                executorService.execute(new HandlerClient(client));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
