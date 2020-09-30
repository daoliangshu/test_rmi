package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import shared.UpperCaseInterface;

public class RMIClient {
	
	private UpperCaseInterface server;

	public RMIClient() {}
	
	public void startClient() throws RemoteException, NotBoundException, MalformedURLException{
		System.out.println("C");

		//Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		System.out.println("D");
		String ipAddress = "192.168.0.10"; //Local IP address 
		System.setProperty("java.rmi.server.hostname",ipAddress);
		Registry r = LocateRegistry.getRegistry("localhost", 1099);
		if(r != null) {
			System.out.println("Registry fetched.");
			server = (UpperCaseInterface)r.lookup("rmi://" + ipAddress + ":1099/Server");
			if(server != null) {
				System.out.println("Server fetched.");
			}else {
				System.out.println("Failed to fetched Server");
			}
		}else {
			System.out.println("Failed getRegistry");
		}
		System.out.println("T");
		//server = (UpperCaseInterface)Naming.lookup("Server");
		
		/*if(registry != null) {
			server= (UpperCaseInterface)registry.lookup("Server");
		}else {
			System.out.println("No registry");
		}
		*/
		
		System.out.println("E");

	}
	
	public String toUpperCase(String arg) {
		
		String res = "";
		try {
			res = server.toUpperCase(arg);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return res;
	}
}
