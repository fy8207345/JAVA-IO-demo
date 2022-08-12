package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Selectors {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 60000));
        channel.configureBlocking(false);
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);

        int interestOps = selectionKey.interestOps();
        boolean interestConnect = SelectionKey.OP_CONNECT == (interestOps & SelectionKey.OP_CONNECT);
        boolean interestRead = SelectionKey.OP_READ == (interestOps & SelectionKey.OP_READ);
        boolean interestWrite = SelectionKey.OP_WRITE == (interestOps & SelectionKey.OP_WRITE);
        boolean interestAccept = SelectionKey.OP_ACCEPT == (interestOps & SelectionKey.OP_ACCEPT);

        int readyOps = selectionKey.readyOps();
        boolean acceptable = selectionKey.isAcceptable();
        boolean connectable = selectionKey.isConnectable();
        boolean readable = selectionKey.isReadable();
        boolean writable = selectionKey.isWritable();

        Selector selector1 = selectionKey.selector();
        SelectableChannel channel1 = selectionKey.channel();

        Object attach = selectionKey.attach(new Object());
        Object attachment = selectionKey.attachment();
    }
}
