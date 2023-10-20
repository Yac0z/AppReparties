package ServerPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket socketServeur = new ServerSocket(8000);
    System.out.println("Serveur est  en attent d'un client  ");
    Socket socket = socketServeur.accept();
    System.out.println("un client est connecté");
    // EX2
    // Pour lire les flux de données envoyé par le client
    InputStream srvrInput = socket.getInputStream();
    // Pour envoyer des flux de données au client
    OutputStream srvrOutput = socket.getOutputStream();

    int val = srvrInput.read();
    System.out.println("Recu");
    int rslt = val * 5;
    srvrOutput.write(rslt);
    System.out.println("Terminé");

    socketServeur.close();
  }
}