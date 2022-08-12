package com.example.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileChannels {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("d:/logs/2022-06-24-0.log", "rw");
        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(byteBuffer); // read file into buffer
        while (bytesRead != -1){
            log.info("read bytes : {}", bytesRead);
            byteBuffer.flip(); // make buffer ready to read from

            while (byteBuffer.hasRemaining()){
                log.info("content : {} - {}", (char) byteBuffer.get(),  //read a byte from buffer
                        byteBuffer.hasArray());
            }

            byteBuffer.clear(); // make buffer ready to write to
            bytesRead = inChannel.read(byteBuffer);
        }

        accessFile.close();
    }
}
