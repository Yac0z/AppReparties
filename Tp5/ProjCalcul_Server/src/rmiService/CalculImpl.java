package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculImpl extends UnicastRemoteObject implements CalculInterface {
  public CalculImpl() throws RemoteException {
    super();

  }

  public double mul(double val1, double val2) throws RemoteException {
    return val1 * val2;
  };
}
