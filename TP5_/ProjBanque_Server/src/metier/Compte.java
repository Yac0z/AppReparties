package metier;

import java.sql.Date;
import java.util.Vector;

public class Compte {
  public static Vector<Compte> all;
  public int code;
  public double solde;
  public Date date;

  public Compte() {
  }

  public Compte(int code, double solde, Date date) {
    this.code = code;
    this.solde = solde;
    this.date = date;
  }

  public static Vector<Compte> getAll() {
    return all;
  }

  public static void setAll(Vector<Compte> all) {
    Compte.all = all;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
