package com.example.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsynchronousFileChannels {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//        read2();
        readWithHandler();
    }

    public static void readWithHandler() throws URISyntaxException, IOException, InterruptedException {
        URL resource = AsynchronousFileChannels.class.getResource("/a.txt");
        Path path = Paths.get(resource.toURI());
        AsynchronousFileChannel asynchronousFileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        asynchronousFileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
        TimeUnit.MILLISECONDS.sleep(500);
    }

    public static void read2() throws URISyntaxException, IOException {
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
