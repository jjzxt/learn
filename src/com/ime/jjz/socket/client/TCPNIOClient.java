package com.ime.jjz.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class TCPNIOClient {
	public static void main(String[] args) {
		try {
			SocketAddress remote = new InetSocketAddress("192.168.1.152",8888);
			
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(false);//设置非阻塞
			channel.connect(remote);
			
			Selector selector = Selector.open();
			channel.register(selector, SelectionKey.OP_CONNECT);//向channel注册selector和感兴趣的连接事件
			
			BufferedReader systemIn=new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				if(channel.isConnected()){
					String command=systemIn.readLine();
					channel.write(Charset.forName("UTF-8").encode(command));
					if(command==null || "quit".equalsIgnoreCase(command.trim())){
						systemIn.close();
						channel.close();
						selector.close();
						System.out.println("Client quit!");
						System.exit(0);
					}
				}
				int nKeys = selector.select();
				//尤其需要注意selector.select抛出IOException的处理和其不阻塞就直接返回的情况,这两种状况有可能造成cpu消耗100%,
				if(nKeys > 0){
					Set<SelectionKey> keys = selector.selectedKeys();
					
					for(SelectionKey key:keys){
						if(key.isConnectable()){
							SocketChannel sc = (SocketChannel)key.channel();
							sc.configureBlocking(false);
							//注册selector和感兴趣的IO事件,一般不直接注册写事件,在发送区缓存未满时一直可写,
							//如注册写事件而不写入数据,会造成CPU使用100%的现象
							sc.register(selector, SelectionKey.OP_READ);
							sc.finishConnect();
							
						}else if(key.isReadable()){//有流可读
							ByteBuffer bb = ByteBuffer.allocate(1024);
							SocketChannel sc = (SocketChannel)key.channel();
							int readBytes = 0;
							int ret = 0;
							while((ret = sc.read(bb)) > 0){
								readBytes += ret;
							}
							bb.flip();
							if(readBytes>0){
								System.out.println(Charset.forName("UTF-8").decode(bb).toString());
								bb = null;
							}
							if(bb != null){
								bb.clear();
							}
							
						}else if(key.isWritable()){//有流可写
							//取消感兴趣写事件的注册
							key.interestOps(key.interestOps() & (~SelectionKey.OP_WRITE));
							SocketChannel sc = (SocketChannel)key.channel();
							ByteBuffer bb = ByteBuffer.allocate(1024);
							int writenedSize = sc.write(bb);//返回成功写入操作系统发送缓存区的字节数,缓存区写满时返回0
							
							if(writenedSize == 0){
								key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
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
