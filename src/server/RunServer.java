package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import shared.UpperCaseInterface;

public class RunServer {
	private static Registry registry = null;
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
		UpperCaseInterface a = new UpperCaseImpl();
		
		//System.setProperty("java.rmi.server.hostname","127.0.0.1");
		try {
			String ipAddress = "192.168.0.10"; //Local IP address 
			System.setProperty("java.rmi.server.hostname",ipAddress);
			registry = LocateRegistry.createRegistry(1099);
			if(registry != null) {
				registry.rebind("rmi://" + ipAddress + ":1099/Server", a);
			}else {
				System.out.println("Failed to create Registry");
			}
			
			
			System.out.println("Server started..");
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
}
