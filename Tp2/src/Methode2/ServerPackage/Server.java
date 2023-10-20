package Methode2.ServerPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Methode2.OperationPackage.Operation;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(2000);
    System.out.println("en attente de client");
    Socket s = ss.accept();
    System.out.println("Client connecté");
    // lecture et ecriture seulement avec un seul octet
    InputStream is = s.getInputStream();
    OutputStream os = s.getOutputStream();
    // lecture et ecriture seulement avec plus un seul octet
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader bfrIn = new BufferedReader(isr);
    PrintWriter pw = new PrintWriter(os, true);
    // lecture des objets
    ObjectInputStream ois = new ObjectInputStream(is);
    Operation myOpr = (Operation) ois.readObject();
    int val1 = myOpr.getVal1();
    int val2 = myOpr.getVal2();
    char opr = myOpr.getOpr();
    // initialization result
    float value = 0;
    // la logique des calcul
    switch (opr) {
      case '+':
        value = val1 + val2;
        break;
      case '-':
        value = val1 - val2;
        break;
      case '/':
        value = val1 / val2;
        break;
      case '*':
        value = val1 * val2;
        break;
      default:
        System.out.println("Opération ivalide");
        break;
    }
    // envoi des résultas valide
    System.out.println("Result : " + value);
    pw.println("Result : " + value);
    ss.close();
  }
}
