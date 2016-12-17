package com.ime.jjz.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements Calc{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CalcImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x+y;
	}
	
	public static void main(String[] args){
		
		try {
			Calc calc = new CalcImpl();
			LocateRegistry.createRegistry(8888);
			Naming.rebind("rmi://localhost:8888/calc", calc);
			
			System.out.println("Ready....");
		} catch (MalformedURLException | RemoteException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
