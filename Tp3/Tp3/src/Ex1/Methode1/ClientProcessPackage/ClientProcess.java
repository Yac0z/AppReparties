package Ex1.Methode1.ClientProcessPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess extends Thread {
  Socket socket;

  public ClientProcess(Socket socket) {
    super();
    this.socket = socket;
  }

  @Override
  public void run() {
    System.out.println("Client Process en execution");
    try {
      InputStream clpInput = this.socket.getInputStream();
      InputStreamReader reader = new InputStreamReader(clpInput);
      BufferedReader clpBfr = new BufferedReader(reader);
      // Pour envoyer des flux de données au serveur
      OutputStream clpOutput = this.socket.getOutputStream();
      PrintWriter clpWriter = new PrintWriter(clpOutput, true);

      // int input = clpInput.read();
      String req = clpBfr.readLine();
      System.out.println("req: " + req);
      clpWriter.println(req + ":Validé");
      System.out.println("client is done");
      // System.out.println("input: " + input);
      // System.out.println("Resutat envoyé");

      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // public static void main(String[] args) {
  // System.out.println("hhh");
  // }
}
