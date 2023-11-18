package Ex2.Methode2.ServerPackage;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

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

        float value = 0;
        String expression = clpBfr.readLine();
        try {
          // ==> On assume que l'oeration est de la forme suivante :3+4/3-4/3/4/3*4 alors
          // si une opérateur existe dans l'expression alors son index est le maximum
          // parmis les autre opérateurs
          int pos = Math.max(expression.indexOf('+'),
              Math.max(expression.indexOf('-'), Math.max(expression.indexOf('/'), expression.indexOf('*'))));

          System.out.println("pos=" + pos);
          char opr = expression.charAt(pos);
          System.out.println("opr=" + opr);
          // extraction des opérandes
          float opr1 = Float.parseFloat(expression.substring(0, pos));
          float opr2 = Float.parseFloat(expression.substring(pos + 1));
          // la logique des calcul
          switch (opr) {
            case '+':
              value = opr1 + opr2;
              break;

            case '-':
              value = opr1 - opr2;
              break;
            case '/':
              value = opr1 / opr2;
              break;
            case '*':
              value = opr1 * opr2;
              break;
            default:
              System.out.println("Opération ivalide");
              System.exit(1);
              break;
          }
          // gestion des exceptions
        } catch (Exception e) {
          clpWriter.println("Opération ivalide");
          System.out.println(e.toString());
          socket.close();
          Thread.currentThread().interrupt();
          // System.exit(1);
        }
        // envoi des résultas valide
        System.out.println("Result : " + value);
        clpWriter.println("Result : " + value);

        socket.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static void main(String[] args) {
    new Server().start();
  }
}