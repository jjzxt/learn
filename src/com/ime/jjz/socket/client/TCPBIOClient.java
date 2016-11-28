package com.ime.jjz.socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class TCPBIOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.1.152",8888);
			
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//优先采用PrintWriter
		    BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		    
		    String command=sysin.readLine();
		    System.out.println("output:"+command);
		   
	    	bw.write("Hello! My name is jjz");
	    	bw.newLine();
		    bw.flush();
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = br.readLine();
		    if(line!= null){
		    	System.out.println(line);
		    }
		    
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
