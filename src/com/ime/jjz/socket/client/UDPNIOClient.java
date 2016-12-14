package com.ime.jjz.socket.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class UDPNIOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel receiveChannel = DatagramChannel.open();
			receiveChannel.configureBlocking(false);
			DatagramSocket socket = receiveChannel.socket();
			socket.bind(new InetSocketAddress(8888));
			
			Selector selector = Selector.open();
			receiveChannel.register(selector, SelectionKey.OP_READ);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
