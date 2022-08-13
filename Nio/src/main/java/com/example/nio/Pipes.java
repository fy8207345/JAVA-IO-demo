package com.example.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

@Slf4j
public class Pipes {

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sink = pipe.sink();
        Pipe.SourceChannel source = pipe.source();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while (buf.hasRemaining()){
            sink.write(buf);
        }

        ByteBuffer sourceBuf = ByteBuffer.allocate(48);
        int length = source.read(sourceBuf);
        log.info("read length : {}", length);
        sourceBuf.flip();
        while (sourceBuf.hasRemaining()){
            byte[] bytes = new byte[sourceBuf.remaining()];
            sourceBuf.get(bytes);
            log.info("content: {}", new String(bytes));
        }
    }
}
