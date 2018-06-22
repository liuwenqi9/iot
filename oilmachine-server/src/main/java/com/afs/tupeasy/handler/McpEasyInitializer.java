
package com.afs.tupeasy.handler;

import com.afs.base.util.MySpringContextUtil;
import com.afs.tupeasy.encoder.McpServerEncoder;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Creates a newly configured  {@link ChannelPipeline}  for a new channel.
 */
public class McpEasyInitializer extends ChannelInitializer<SocketChannel> {
	
	@Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        
        ChannelHandler mcpEasyDecoder = (ChannelHandler) MySpringContextUtil.getBean("mcpEasyDecoder");
        pipeline.addLast("mcpEasyDecoder", mcpEasyDecoder);
        pipeline.addLast("McpServerEncoder", new McpServerEncoder());
        pipeline.addLast("Myhandler", new McpEasyHandler());
    }
}
