package com.ime.jjz.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author jjz
 * mina 服务端
 */
public class MinaServer {
		//定义监听端口
		private static final int PORT = 8888;
		
		/**
		 * @param args
		 * @throws IOException
		 */
		public static void main(String[] args) throws IOException{
			//创建服务端监控线程
			IoAcceptor acceptor = new NioSocketAcceptor();
			acceptor.getSessionConfig().setMaxReadBufferSize(1024);
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			
			//设置日志记录器
			acceptor.getFilterChain().addLast("logger", new LoggingFilter());
			//设置编码过滤器
			acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
			
			//指定业务逻辑处理器
			acceptor.setHandler(new ServerHandler());
			//设置端口号
			acceptor.bind(new InetSocketAddress(PORT));
			//启动监听线程
			acceptor.bind();
		}
}
