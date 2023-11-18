package Ex1.Methode1.ServerPackage;

import java.net.ServerSocket;
import java.net.Socket;

import Ex1.Methode1.ClientProcessPackage.ClientProcess;

public class Server {
  public static void main(String[] args) throws Exception {

    try (ServerSocket serverSocket = new ServerSocket(2023)) {
      System.out.println("En attente de client...");

      while (true) {
        // acceptation des processus client
        Socket serviceSocket = serverSocket.accept();
        System.out.println("Un nouveau client est connecté ");
        ClientProcess clp = new ClientProcess(serviceSocket);
        // lancemment du processus client
        clp.start();
      }

    }

  }
}
