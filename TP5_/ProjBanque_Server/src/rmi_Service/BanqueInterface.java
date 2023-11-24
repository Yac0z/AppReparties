package rmi_Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import metier.Compte;

public interface BanqueInterface extends Remote

{
  String creeCompte(Compte c) throws RemoteException;

  Compte consulterCompte(int codes) throws RemoteException;

  String getInfoCompte(int codes) throws RemoteException;

  Vector<Compte> getComptes() throws RemoteException;

  double convertirMontant(double mt) throws RemoteException;
}
