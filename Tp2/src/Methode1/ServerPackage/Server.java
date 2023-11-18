package Methode1.ServerPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(2000);
    Socket s = ss.accept();
    System.out.println("Client connecté");
    // lecture et ecriture seulement avec un seul octet
    InputStream is = s.getInputStream();
    OutputStream os = s.getOutputStream();
    // lecture et ecriture seulement avec plus un seul octet
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader bfrIn = new BufferedReader(isr);
    PrintWriter pw = new PrintWriter(os, true);
    // initialization result
    float value = 0;
    String expression = bfrIn.readLine();
    try {
      // ==> On assume que l'oeration est de la forme suivante :3+4/3-4/3/4/3*4 alors
      // si une opérateur existe dans l'expression alors son index est le maximum
      // parmis les autre opérateurs
      int pos = Math.max(expression.indexOf('+'),
          Math.max(expression.indexOf('-'), Math.max(expression.indexOf('/'), expression.indexOf('*'))));

      System.out.println("pos=" + pos);
      char opr = expression.charAt(pos);
      System.out.println("opr=" + opr);
      // extraction des opérandes
      float opr1 = Float.parseFloat(expression.substring(0, pos));
      float opr2 = Float.parseFloat(expression.substring(pos + 1));
      // la logique des calcul
      switch (opr) {
        case '+':
          value = opr1 + opr2;
          break;

        case '-':
          value = opr1 - opr2;
          break;
        case '/':
          value = opr1 / opr2;
          break;
        case '*':
          value = opr1 * opr2;
          break;
        default:
          System.out.println("Opération ivalide");
          System.exit(1);
          break;
      }
      // gestion des exceptions
    } catch (Exception e) {
      pw.println("Opération ivalide");
      System.out.println(e.toString());
      System.exit(1);
    }
    // envoi des résultas valide
    System.out.println("Result : " + value);
    pw.println("Result : " + value);

    ss.close();
  }
}
