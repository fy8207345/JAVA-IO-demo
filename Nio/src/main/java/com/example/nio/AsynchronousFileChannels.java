package com.example.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannels {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource = AsynchronousFileChannels.class.getResource("/a.txt");
        Path path = Paths.get(resource.toURI());
        AsynchronousFileChannel asynchronousFileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> read = asynchronousFileChannel.read(buffer, 0);

        while(!read.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();

        asynchronousFileChannel.close();
    }
}
