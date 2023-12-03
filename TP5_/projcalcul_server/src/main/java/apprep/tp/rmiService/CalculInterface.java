
package apprep.tp.rmiService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculInterface extends Remote {
  double mul(double a, double b) throws RemoteException;

  double add(double a, double b) throws RemoteException;

  double sous(double a, double b) throws RemoteException;

  double div(double a, double b) throws RemoteException;

}