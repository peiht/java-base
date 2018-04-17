package learning.net.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

	private int port;
	public NettyServer(int port){
		super();
		this.port = port;
	}
	
	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		System.out.println("准备运行端口："+port);
		
		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb = sb.group(bossGroup, workerGroup);
			sb = sb.channel(NioServerSocketChannel.class);
			sb = sb.childHandler(new ChannelInitializer<SocketChannel>(){
	
				@Override
				protected void initChannel(SocketChannel sc) throws Exception {
					sc.pipeline().addLast(new ServerHandler());
				}
				
			});
			sb = sb.option(ChannelOption.SO_BACKLOG, 128);
			sb = sb.childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture cf = sb.bind(port).sync();
			cf.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int port;
		if(args.length >0){
			port = Integer.parseInt(args[0]);
		}else{
			port = 8080;
		}
		new NettyServer(port).run();
		System.out.println("server :run()");
	}

}
