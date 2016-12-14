package com.ime.jjz.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @author jjz
 * mina 客户端
 */
public class MinaClient {
	//定义连接ip和端口
	private static final String HOST = "localhost";
	private static final int PORT = 8888;
	
	public static void main(String[] args) {
		//创建客户端连接器
		NioSocketConnector connector = new NioSocketConnector(); 
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		
		//设置超时连接
		connector.setConnectTimeoutCheckInterval(300);
		connector.setHandler(new ClientHandler());
		
		//建立连接
		ConnectFuture cf = connector.connect(new InetSocketAddress(HOST, PORT));
		//等待连接完成
		cf.awaitUninterruptibly();
		
		//等待连接断开
		cf.getSession().getCloseFuture().awaitUninterruptibly();
		//释放连接
		connector.dispose();
	}
}
