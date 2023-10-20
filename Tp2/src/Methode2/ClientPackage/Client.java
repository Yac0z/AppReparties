package Methode2.ClientPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Methode2.OperationPackage.Operation;

public class Client {
  public static void main(String[] args) throws Exception {
    Socket s = new Socket("localhost", 2000);
    System.out.println("Client Connecté au serveur");
    // lecture et ecriture seulement avec un seul octet
    InputStream is = s.getInputStream();
    OutputStream os = s.getOutputStream();
    // lecture et ecriture seulement avec plus un seul octet
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader bfrIn = new BufferedReader(isr);
    PrintWriter pw = new PrintWriter(os, true);

    // lecture des objects
    ObjectOutputStream oos = new ObjectOutputStream(os);

    // Creation d'un instance de classe opération
    Operation myOp = new Operation();
    // envoi de l'objet serializé
    oos.writeObject(myOp);
    // affichage de resultat
    System.out.println(bfrIn.readLine());

    s.close();
  }
}
