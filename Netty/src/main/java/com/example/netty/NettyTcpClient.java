package com.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;

public class NettyTcpClient {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.option(ChannelOption.SO_RCVBUF, 1024);
        bootstrap.option(ChannelOption.AUTO_CLOSE, false);
        ChannelFuture connect = bootstrap.connect("127.0.0.1", 60000);
    }
}
