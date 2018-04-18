package learning.net.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ServerHandler extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg){
		try{
			ByteBuf in = (ByteBuf) msg;
			//byte[] req = new byte[in.readableBytes()];
			//in.readBytes(req);
			//System.out.println("message:"+new String(req));
			System.out.println(in.toString(CharsetUtil.UTF_8));
		}finally{
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
