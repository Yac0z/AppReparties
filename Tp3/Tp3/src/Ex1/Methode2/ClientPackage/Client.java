package Ex1.Methode2.ClientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 10; i++) {
      Socket socketClient = new Socket("localhost", 2023);
      InputStream cltInput = socketClient.getInputStream();
      InputStreamReader clientIsr = new InputStreamReader(cltInput);
      BufferedReader clientBfrIn = new BufferedReader(clientIsr);
      // Pour envoyer des flux de données au serveur
      OutputStream cltOutput = socketClient.getOutputStream();
      //
      PrintWriter pw = new PrintWriter(cltOutput, true);
      //
      pw.println("Eco pour Client " + (i + 1));
      System.out.println("client " + (i + 1) + " a envoye " + (9999 + i));
      System.out.println("response server pour client " + (i + 1) + "= " + clientBfrIn.readLine());
      socketClient.close();
    }
  }
}