package com.ime.jjz.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.ime.jjz.rmi.server.Calc;

public class RmiClient{
	public static void main(String[] args) {
		try {
			Calc calc = (Calc)Naming.lookup("rmi://localhost:8888/calc");
			
			System.out.println(calc.add(3, 9));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
