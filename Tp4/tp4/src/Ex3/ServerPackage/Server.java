package Ex3.ServerPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

  public static void main(String[] args) throws IOException {

    try (// creation d'une socket liee au port 2023
        DatagramSocket socket = new DatagramSocket(2023)) {
      // tableau de 1024 octets qui continedra les donnees reçues
      byte[] buffer = new byte[1024];
      String donnees = "";
      String msg = "";
      int taille = 0;
      System.out.println("Lancement du serveur ");

      while (true) {
        // création d'un paquet en utilisant le tableau d'octets
        DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
        DatagramPacket envoi = null;

        socket.receive(paquet);
        System.out.println("\n" + paquet.getAddress());
        taille = paquet.getLength();
        // recuperation des donnees
        donnees = new String(paquet.getData(), 0, taille);
        System.out.println("Donnees reçues " + donnees);
        String validReq = "Quelle est heure est-il ? ";
        if (donnees.equals(validReq)) {
          long millis = System.currentTimeMillis();
          // creating a new object of the class Date
          java.util.Date date = new java.util.Date(millis);
          msg = date.toString();
          // System.out.println(date);
        } else {
          msg = "Invalid request ! Try again";
        }
        // msg =

        System.out.println("Donnees envoyees = " + msg);
        envoi = new DatagramPacket(msg.getBytes(), msg.length(), paquet.getAddress(), paquet.getPort());
        socket.send(envoi);
      }
    }

  }

}