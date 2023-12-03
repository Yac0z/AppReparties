package rmiClient;

import java.rmi.Naming;

import apprep.tp.rmiService.CalculInterface;

public class CalculClient {
  public static void main(String[] args) {
    try {
      CalculInterface stub = (CalculInterface) Naming.lookup("MultiplyObj");
      System.out.println(stub.mul(55, 1));
      System.out.println(stub.add(55, 1));

    } catch (Exception e) {
      System.out.println("##########");
      System.out.println(e.toString());
    }
  }
}
