package ChatRoomServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Loinbo
 * DATE:2019/8/16
 * TIME:14:25
 */

public class HandlerClient implements Runnable{

    /**
     * 客户端实现：
     * 1.注册功能：创建Socket,给服务器发送注册执行(消息)
     * 2.群聊功能：客户端发送和接收数据
     * 3.私聊功能：客户端指定客户端(用户),发送和接收数据
     * 4.推出功能：给服务器发送退出指令(消息)
     *
     * 命令行交互式输入输出
     */

    private static final Map<String, Socket> ONLINE_CLIENT_MAP = new ConcurrentHashMap<>();

    private final Socket client;

    public HandlerClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            InputStream clientInput = client.getInputStream();
            Scanner sc = new Scanner(clientInput);

            /**
             * 消息是按行读取的
             * 1.注册：register:<userName> 例如：register:张三
             * 2.群聊：groupChat:<message> 例如:groupChat:大家好
             * 3.私聊：privateChat:<userName>:<message> 例如：privateChat:张三：你好，打钱
             * 4.退出：bye
             */

            while(true){
                String data = sc.nextLine();
                if(data.startsWith("register:")){
                    String userName = data.split(":")[1];
                    register(userName);
                    continue;
                }
                if(data.startsWith("groupChat:")){
                    String message = data.split(":")[1];
                    groupChat(message);
                    continue;
                }
                if(data.startsWith("privateChat:")){
                    String[] segments = data.split(":");
                    String targetUserName = segments[1];
                    String message = segments[2];
                    privateChat(targetUserName,message);
                    continue;
                }
                if(data.equals("bye")){
                    bye();
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 注册功能
     * 以 userName 为 key 注册当前用户(Socket client)
     * @param userName
     */
    private void register(String userName) {

        ONLINE_CLIENT_MAP.put(userName, this.client);
        printOnlineClient();
        this.sendMessage(this.client, "恭喜" + userName + "注册成功!", false);
    }

    /**
     * 信息发送
     * @param target
     * @param message
     * @param prefix
     */
    private void sendMessage(Socket target, String message, boolean prefix) {
        OutputStream clientOutput = null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            if(prefix){
                String currentUserName = this.getCurrentUserName();
                writer.write("<" + currentUserName + ":说>" + message + "\n");
            } else {
                writer.write(message + "\n");
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentUserName() {
        for(Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()){
            Socket target = entry.getValue();
            if(target.equals(this.client)){
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     * 打印在线客户端
     */
    private void printOnlineClient() {
        System.out.println("当前在线人数:" + ONLINE_CLIENT_MAP.size() + "用户列表如下");
        for(String userName : ONLINE_CLIENT_MAP.keySet()){   //keySet()返回的是Map对象中key值对应的Set集合
            System.out.println(userName);
        }
    }

    /**
     * 群聊功能
     * 发送 message : groupChat:<message>
     * @param message
     */
    private void groupChat(String message) {
        for(Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()){
            Socket target = entry.getValue();
            if(target.equals(this.client)){
                continue;
            }
            this.sendMessage(target,message,true);
        }

    }

    /**
     * 私聊功能
     * 给 targetUserName 发送 message: privateChat:<userName>:<message>
     * @param targetUserName
     * @param message
     */
    private void privateChat(String targetUserName, String message) {
        Socket target = ONLINE_CLIENT_MAP.get(targetUserName);
        if(target == null){
            this.sendMessage(this.client,"该用户不存在" + targetUserName,false);
        } else {
            this.sendMessage(target, message, true);
        }
    }

    /**
     * 退出功能
     */
    private void bye() {
        for(Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()){
            Socket target = entry.getValue();
            if(target.equals(this.client)){
                ONLINE_CLIENT_MAP.remove(entry.getKey());
                break;
            }
        }
        printOnlineClient();
    }
}
