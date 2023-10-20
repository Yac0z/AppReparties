package Methode2.OperationPackage;

import java.io.Serializable;
import java.util.Scanner;

public class Operation implements Serializable {
  private int val1;
  private int val2;
  private char opr;

  public Operation() {
    int val1 = 0, val2 = 0;
    char opr = ' ';
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Donner une opérande");
      val1 = scanner.nextInt();
      try {
        System.out.println("Donner une opérande");
        val2 = scanner.nextInt();
        try {
          scanner.nextLine();
          System.out.println("Donner un opérateur");
          opr = (scanner.nextLine()).charAt(0);
        } catch (Exception e) {
          System.out.println("Invalid input: ");

        }
      } catch (Exception e) {
        System.out.println("Invalid input: ");

      }
    } catch (Exception e) {
      System.out.println("Invalid input: ");
    }
    setVal1(val1);
    setVal2(val2);
    setOpr(opr);

  }

  public int getVal1() {
    return val1;
  }

  public int getVal2() {
    return val2;
  }

  public char getOpr() {
    return opr;
  }

  public void setVal1(int val1) {

    this.val1 = val1;
  }

  public void setVal2(int val2) {
    this.val2 = val2;
  }

  public void setOpr(char opr) {
    this.opr = opr;
  }

}
