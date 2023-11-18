package rmiService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * MutiplicationInteface
 */
public interface CalculInterface extends Remote {
  public double mul(double val1, double val2) throws RemoteException;
}