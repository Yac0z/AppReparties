package Ex2.Methode1.ClientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) throws IOException {
    Scanner userInput = new Scanner(System.in);
    for (int i = 0; i < 4; i++) {
      Socket socketClient = new Socket("localhost", 2023);
      InputStream cltInput = socketClient.getInputStream();
      InputStreamReader clientIsr = new InputStreamReader(cltInput);
      BufferedReader clientBfrIn = new BufferedReader(clientIsr);
      // Pour envoyer des flux de données au serveur
      OutputStream cltOutput = socketClient.getOutputStream();
      //
      PrintWriter pw = new PrintWriter(cltOutput, true);
      //
      // Demander d'utlisateur d'ecrire
      System.out.println("donnez une operation pour envoyer au serveur");

      String val = userInput.nextLine();
      // envoi d'expression
      pw.println(val);
      // lire le résultat
      String res = clientBfrIn.readLine();
      System.out.println(res);
      socketClient.close();
    }
    userInput.close();
  }
}