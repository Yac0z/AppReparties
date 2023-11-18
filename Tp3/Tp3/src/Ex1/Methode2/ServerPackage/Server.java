package Ex1.Methode2.ServerPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
  public void run() {

    try (ServerSocket serverSocket = new ServerSocket(2023)) {
      System.out.println("En attente de client...");

      while (true) {
        Socket serviceSocket = serverSocket.accept();
        System.out.println("Un nouveau client est connecté ");
        ClientProcess clp = new ClientProcess(serviceSocket);
        clp.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

class ClientProcess extends Thread {
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

  // lancement du server qui implemente l'interface Runnable
  public static void main(String[] args) {
    new Server().start();
  }
}
