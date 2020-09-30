package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException{
		RMIClient client = new RMIClient();
		System.out.println("A");
		try {
			client.startClient();
			System.out.println("Client started");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("B");

		Scanner in = new Scanner(System.in);
		String read = "";
		while(true) {
			System.out.println("Input : "  );
			read = in.nextLine();
			if("exit".equalsIgnoreCase(read))return;
			String tmp = client.toUpperCase(read);
			System.out.println(" UpperCase > " + tmp);
		}
		
	}
}
