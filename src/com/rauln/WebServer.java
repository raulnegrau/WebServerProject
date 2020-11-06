package com.rauln;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable{
    private int port = 8080;
    private Socket socket;


    private static final String DEFAULT_FILE = "index.html";
    private static final String FILE_NOT_FOUND = "404.html";

    public WebServer(Socket socket){
        this.socket = socket;
        WebServerHandler();
    }

    public void WebServerHandler(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Connection Socket Created");
            try {
                while (true) {
                    System.out.println("Waiting for Connection");
                    serverSocket.accept();
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port : " + port);
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port :" + port);
                System.exit(1);
            }
        }
    }

    public int getPort(){
        return port;
    }

    public void setPort(int port){
        this.port = port;
    }

    @Override
    public void run() {

    }
}
