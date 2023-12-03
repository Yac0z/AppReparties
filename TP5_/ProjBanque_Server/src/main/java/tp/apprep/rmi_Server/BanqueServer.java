package tp.apprep.rmi_Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import tp.apprep.rmi_Service.BanqueImpl;

public class BanqueServer {
  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);
      BanqueImpl bank = new BanqueImpl();
      Naming.rebind("BankObj", bank);
      System.out.println("Serveur RMI Lancé");

    } catch (Exception e) {
      System.out.println("####w####");
      System.out.println(e.getStackTrace());
      System.out.println(e.toString());
    }

  }
}
