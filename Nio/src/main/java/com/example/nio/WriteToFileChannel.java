package com.example.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
public class WriteToFileChannel {

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open(Paths.get("d:/c.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//        ByteBuffer byteBuffer = ByteBuffer.wrap("hello".getBytes());
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        //转换为写模式
        byteBuffer.clear();
        byteBuffer.put((byte)'h');
        byteBuffer.put((byte)'h');
        byteBuffer.put((byte)'h');
        //必须转换为读模式，否则读取不到
        byteBuffer.flip();
        int lengthWrite = fileChannel.write(byteBuffer);
        log.info("lengthWrite: {}", lengthWrite);
        //flush到磁盘
        fileChannel.force(true);
        fileChannel.close();
    }
}