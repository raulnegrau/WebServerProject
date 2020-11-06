package com.rauln;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Socket socket = new Socket();
        WebServer webServer = new WebServer(socket);
        Thread thread = new Thread(webServer);
        thread.start();
    }
}
