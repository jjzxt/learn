package com.ime.jjz.socket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class TCPNIOServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocketChannel channel = ServerSocketChannel.open();
			ServerSocket socket = channel.socket();
			
			socket.bind(new InetSocketAddress(8888));
			channel.configureBlocking(false);
			
			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_ACCEPT);
			
			
			while(true){
				int selectedKey = selector.select();
				if(selectedKey > 0){
					Set<SelectionKey> nkeys = selector.selectedKeys();
					for(SelectionKey key:nkeys){
						if(key.isAcceptable()){
							ServerSocketChannel server = (ServerSocketChannel)key.channel();
							SocketChannel sc = server.accept();
							if(sc == null){
								continue;
							}
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
							
						}else if(key.isReadable()){
							ByteBuffer bb = ByteBuffer.allocate(1024);
							SocketChannel sc = (SocketChannel)key.channel();
							int readBytes = 0;
							int ret = 0;
							String message=null;
							while((ret = sc.read(bb)) > 0){
								readBytes += ret;
							}
							bb.flip();
							if(readBytes>0){
								message= Charset.forName("UTF-8").decode(bb).toString();
								System.out.println(message);
								bb = null;
							}
							if(bb != null){
								bb.clear();
							}
							if(readBytes>0){
								System.out.println("Message from client: "+ message);
								if("quit".equalsIgnoreCase(message.trim())){
									sc.close();
									selector.close();
									System.out.println("Server has been shutdown!");
									System.exit(0);
								}
								String outMessage="Server response："+message;
								sc.write(Charset.forName("UTF-8").encode(outMessage));
							}
						}
					}
					selector.selectedKeys().clear();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
