package rmiServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculServer {
  public static void main(String[] args) {

    try {

      LocateRegistry.createRegistry(1099);
      CalculImpl multi = new CalculImpl();
      Naming.rebind("MultiplyObj", multi);
    } catch (Exception e) {
      System.out.println("########");
      System.out.println(e.toString());
    }

  }
}
