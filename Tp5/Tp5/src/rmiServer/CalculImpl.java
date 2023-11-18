package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmiService.CalculInterface;

public class CalculImpl extends UnicastRemoteObject implements CalculInterface {
  protected CalculImpl() throws RemoteException {
    super();

  }

  public float mul(float val1, float val2) throws RemoteException {
    return val1 * val2;
  };
}
