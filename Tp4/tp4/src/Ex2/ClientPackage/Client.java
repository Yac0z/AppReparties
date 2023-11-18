package Ex2.ClientPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Saisir un message à envoyer");
      String ch = scanner.nextLine();
      int length = ch.length();

      // données à envoyer
      byte[] buffer = ch.getBytes();
      try (// crèation d'une socket , sans la lier a un port particulier
          DatagramSocket socket = new DatagramSocket()) {
        // creation du paquet l'addresse du serveur
        InetSocketAddress ia = new InetSocketAddress("localhost", 2023);

        DatagramPacket donneesEmises = new DatagramPacket(buffer, length, ia);
        // envoi du paquet via la socket
        socket.send(donneesEmises);

        DatagramPacket donneesRecues = new DatagramPacket(new byte[1024], 1024);
        socket.receive(donneesRecues);
        System.out.println("Message : " + new String(donneesRecues.getData(), 0, donneesRecues.getLength()));
        System.out.println("de : " + donneesRecues.getAddress() + ":" + donneesRecues.getPort());
      }
    }
  }
}
