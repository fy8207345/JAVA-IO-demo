package com.example.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SocketChannels {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 60000));
        while (!socketChannel.finishConnect()){
            log.info("not connected");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        FileChannel fileChannel = FileChannel.open(Paths.get("d:/a.txt"), StandardOpenOption.READ);
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        socketChannel.close();
    }
}
