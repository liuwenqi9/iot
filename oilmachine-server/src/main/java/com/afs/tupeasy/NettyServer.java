/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.afs.tupeasy;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afs.tupeasy.handler.McpEasyInitializer;

public class NettyServer implements Runnable{
	private static Logger log = LoggerFactory.getLogger(NettyServer.class);

	private int port;
	private String ip = "localhost";
	
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}
    
    private int backLog;	
	public int getBackLog() {
		return backLog;
	}

	public void setBackLog(int backLog) {
		this.backLog = backLog;
	}

	public NettyServer(){

	}
	
	public void startService(){
		Thread thread = new Thread(this);
		thread.start();
	}
    public void run(){
    	
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .option(ChannelOption.SO_BACKLOG, backLog)
             .childHandler(new McpEasyInitializer());
             try {
            	 log.info("start service in port:{}",this.port);
				b.bind(port).sync().channel().closeFuture().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    
	public int getPort() {
		return port;
	}


    public NettyServer(int port) {
        this.port = port;
    }

}
