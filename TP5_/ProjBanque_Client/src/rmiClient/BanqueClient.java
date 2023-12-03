package rmiClient;

import java.rmi.Naming;
import java.util.Date;

import tp.apprep.metier.Compte;
import tp.apprep.rmi_Service.BanqueInterface;

public class BanqueClient {
  public static void main(String[] args) {
    try {
      BanqueInterface stub = (BanqueInterface) Naming.lookup("BankObj");

      stub.creeCompte(new Compte());
      stub.creeCompte(new Compte(1, 1000, new Date()));
      System.out.println(stub.convertirMontant(1000));
      System.out.println(stub.getComptes());

    } catch (Exception e) {
      System.out.println("##########");
      System.out.println(e.toString());
    }
  }
}
