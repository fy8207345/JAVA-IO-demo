package com.example.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

@Slf4j
public class EchoClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 60000);
        socket.connect(inetSocketAddress, 3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        socket.close();
    }
}
