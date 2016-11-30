package com.ime.jjz.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPBIOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//UDP/IP 是无连接的,如果希望双向通信,就必须启动一个监听端口,承担服务器的职责
			DatagramSocket serverSocket = new DatagramSocket(8888);
			byte[] buffer = new byte[65507];
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			DatagramSocket socket = new DatagramSocket();
			
			InetAddress addr = InetAddress.getByName("localhost");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			boolean flag = true;
			while(flag){
					String command = br.readLine();
					byte[] datas = command.getBytes("UTF-8");
					DatagramPacket packet = new DatagramPacket(datas, datas.length, addr, 8889); 
					socket.send(packet);
					if(command == null || "quit".equalsIgnoreCase(command)){
						flag=false;
						System.out.println("Client quit!");
						socket.close();
						continue;
					}
					serverSocket.receive(receivePacket);
					//超过packet长度的部分删除
					String receiveResponse=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
					System.out.println(receiveResponse);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
