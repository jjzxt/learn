package com.ime.jjz.socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPBIOServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8888);

			Socket socket = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		    String line = br.readLine();
		    if(line != null){
		    	
				System.out.println("input:"+line);
				bw.write("input:"+line);
				bw.newLine();
				bw.flush();
			}
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
