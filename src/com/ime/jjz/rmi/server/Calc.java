package com.ime.jjz.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote{
	public abstract int add(int x,int y) throws RemoteException;
}
