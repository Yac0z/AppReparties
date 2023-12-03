package apprep.tp.rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculImpl extends UnicastRemoteObject implements CalculInterface {
  public CalculImpl() throws RemoteException {
    super();

  }

  public double mul(double a, double b) {
    return a * b;
  }

  public double add(double a, double b) {
    return a + b;
  }

  public double sous(double a, double b) {
    return a - b;
  }

  public double div(double a, double b) {
    return a / b;
  }

}
