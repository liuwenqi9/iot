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
package com.afs.tupeasy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.afs.base.util.MyExceptionUtil;
import com.afs.tupeasy.base.NettyReceiveMessageService;
import com.afs.tupeasy.base.NettyReceiveMessageServiceImpl;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;

/**
 * Handles a server-side channel.
 */
@Sharable
public class McpEasyHandler extends SimpleChannelInboundHandler<AbstractMcpEasyMessage> {
	private static Logger log = LoggerFactory.getLogger(McpEasyHandler.class);
    private NettyReceiveMessageService receiveMessageService = new NettyReceiveMessageServiceImpl();
    public McpEasyHandler(){
    	
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	log.info("channelActive");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, AbstractMcpEasyMessage request) throws Exception {
    	if(request.isCheckbitOk()){
    		receiveMessageService.onReceiveMessage(request, ctx);
    	}else{
    		log.warn("CheckbitOk is error ,igone message");
    	}
    	
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	log.error(MyExceptionUtil.getStackTrace(cause));
        ctx.close();
    }
}
