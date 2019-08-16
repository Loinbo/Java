package ChatRoomClient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2019/8/16
 * TIME:12:06
 */

public class WriteDataToServerThread extends Thread{

    private final Socket client;


    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {

            OutputStream clientOutput = this.client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            Scanner sc= new Scanner(System.in);

            while(true){
                System.out.println("请输入>> ");
                String data = sc.nextLine();
                writer.write(data + "\n");
                writer.flush();
                if(data.equals("bye")){
                    break;
                }
            }
            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
