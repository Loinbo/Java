package com.lamb;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Loinbo
 * DATE:2019/8/30
 * TIME:10:42
 */

public class Server {
    private Controller staticController = new StaticController();
    private CustomClassLoader classLoader = new CustomClassLoader();

    public static void main(String[] args) throws IOException {
        new Server().run();
    }

    private void run() throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Request request = Request.parse(socket.getInputStream());
                        System.out.println(request);
                        Response response = Response.build(socket.getOutputStream());
                        Controller controller = null;
                        if (hasStaticFile(request.getUrl())) {
                            controller = staticController;
                        } else {
                            String className;
                            if (request.getUrl().equals("/")) {
                                className = "ListController";
                            } else if (request.getUrl().equals("/a")) {
                                className = "ArticleController";
                            } else if (request.getUrl().equals("/post")) {
                                className = "PostController";
                            } else {
                                className = "ListController";
                            }
                            Class<?> cls = classLoader.loadClass(className);
                            controller = (Controller)cls.newInstance();
                        }

                        if (request.method.toUpperCase().equals("GET")) {
                            controller.doGet(request, response);
                        } else {
                            controller.doPost(request, response);
                        }

                        response.flush();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private boolean hasStaticFile(String url) {
        if (url.equals("/")) {
            url = "index.html";
        }
        String filename = "D:\\\\LAMB\\Code\\MyHTTPDemoController\\webapp\\" + url;
        File file = new File(filename);
        return file.exists();
    }
}

