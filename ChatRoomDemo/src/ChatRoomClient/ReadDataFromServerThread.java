package ChatRoomClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2019/8/16
 * TIME:12:06
 *
 * 客户端从服务器端读取数据线程
 */

public class ReadDataFromServerThread extends Thread{

    private final Socket client;

    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {

            InputStream clientInput = this.client.getInputStream();
            Scanner sc = new Scanner(clientInput);

            while(true){
                String data = sc.nextLine();
                System.out.println("来自服务端消息：" + data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
