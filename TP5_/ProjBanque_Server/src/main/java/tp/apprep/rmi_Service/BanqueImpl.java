package tp.apprep.rmi_Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import tp.apprep.metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements BanqueInterface {

  public BanqueImpl() throws RemoteException {
    super();
  }

  public String creeCompte(Compte c) throws RemoteException {
    c = new Compte();
    return c.toString() + "\n" + "Compte creé avec succès";
  };

  public Compte consulterCompte(int code) throws RemoteException {
    for (Compte cpt : Compte.all) {
      if (cpt.code == code) {
        return cpt;
      }

    }
    return null;
  };

  public String getInfoCompte(int codes) throws RemoteException {
    return consulterCompte(codes).toString();
  };

  public Vector<Compte> getComptes() throws RemoteException {
    return Compte.all;
  };

  public double convertirMontant(double mt) throws RemoteException {
    return mt * 3.3;
  }

  @Override
  public void ajoutMontant(double mt, Compte cpt) throws RemoteException {
    cpt.setSolde(cpt.getSolde() + mt);

    throw new UnsupportedOperationException("Unimplemented method 'ajoutMontant'");
  }

  @Override
  public void retirerMontant(double mt, Compte cpt) throws RemoteException {
    if (cpt.getSolde() >= mt) {
      cpt.setSolde(cpt.getSolde() - mt);

      return;

    }
    throw new UnsupportedOperationException("Solde insufficient");

  };
}
