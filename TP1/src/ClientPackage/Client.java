package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws IOException {
    System.out.println("client non connecté");
    Socket socketClient = new Socket(InetAddress.getLocalHost(), 8000);
    System.out.println("Client Connecté");

    // EX2
    // Pour lire les flux de données envoyé par le serveur
    InputStream cltInput = socketClient.getInputStream();
    // Pour envoyer des flux de données au serveur
    OutputStream cltOutput = socketClient.getOutputStream();

    Scanner Scanner = new Scanner(System.in);
    System.out.println("Donner le nombre désiré");
    int val = 0;
    try {

      val = Scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Merci d'enter un entier");
    }
    cltOutput.write(val);
    int rslt = cltInput.read();
    System.out.println("La resultat est: " + rslt);

    socketClient.close();
    // Les Sockets sont des ressources alors il faut les fermer a la fin du methode
  }
}
