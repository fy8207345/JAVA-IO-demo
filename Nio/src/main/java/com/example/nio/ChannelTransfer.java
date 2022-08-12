package com.example.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("d:/a.txt", "r");
        FileChannel channel = accessFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("d:/b.txt", "rwd");
        FileChannel toFileChannel = toFile.getChannel();
        toFileChannel.transferFrom(channel, channel.position(), channel.size());
        toFile.close();
        accessFile.close();
    }
}
