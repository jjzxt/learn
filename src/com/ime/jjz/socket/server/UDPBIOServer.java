package com.ime.jjz.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBIOServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//UDP/IP 是不建立连接的,如果希望双向通信,就必须启动一个监听端口,承担服务器的职责
			DatagramSocket serverSocket = new DatagramSocket(8889);
			byte[] buffer = new byte[65507];
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			DatagramSocket socket = new DatagramSocket();
			
			InetAddress addr = InetAddress.getByName("localhost");
			
			while(true){
					serverSocket.receive(receivePacket);
					String receiveRequest=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
					if("quit".equalsIgnoreCase(receiveRequest)){
						serverSocket.close();
						System.exit(0);
					}else{
						System.out.println("Message from client: "+ receiveRequest);
						receivePacket.setLength(buffer.length);
						String response="Server response："+receiveRequest;
						byte[] datas=response.getBytes("UTF-8");
						DatagramPacket responsePacket=new DatagramPacket(datas,datas.length,addr,8888);
						socket.send(responsePacket);
						Thread.sleep(100);
					}
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
