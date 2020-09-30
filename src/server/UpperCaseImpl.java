package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.UpperCaseInterface;

public class UpperCaseImpl	implements UpperCaseInterface {
	
	public UpperCaseImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	
	@Override
	public String toUpperCase(String str) throws RemoteException{
		return str.toUpperCase();
	}
}
