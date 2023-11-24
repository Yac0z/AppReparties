package rmi_Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi_Service.BanqueImpl;

public class BanqueServer {
  public static void main(String[] args) {
    try {

      LocateRegistry.createRegistry(1099);
      BanqueImpl bank = new BanqueImpl();
      Naming.rebind("BankObj", bank);
    } catch (Exception e) {
      System.out.println("########");
      System.out.println(e.toString());
    }

  }
}
