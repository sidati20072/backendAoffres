package tn.isetso.service;

import tn.isetso.entities.Abonnement;
import tn.isetso.entities.Facture;

public interface FactureService {
    public Facture createFacture(Abonnement abonnement , AbonnementData data);
}
