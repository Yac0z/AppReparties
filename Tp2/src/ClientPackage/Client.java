package ClientPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

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

    // lecture des dinnées utilisateur de taille supérieur qu'un octet
    InputStreamReader isrSys = new InputStreamReader(System.in);
    BufferedReader bfrInSys = new BufferedReader(isrSys);

    // Demander d'utlisateur d'ecrire
    System.out.println("donnez une operation pour envoyer au serveur");
    String val = bfrInSys.readLine();
    // envoi d'expression
    pw.println(val);
    // lire le résultat
    String res = bfrIn.readLine();
    System.out.println(res);

    s.close();
  }
}
