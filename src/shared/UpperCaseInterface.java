package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseInterface extends Remote{
	String toUpperCase(String str) throws RemoteException;
}
