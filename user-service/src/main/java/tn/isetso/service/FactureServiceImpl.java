package tn.isetso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isetso.dao.EntrepriseRepository;
import tn.isetso.dao.FactureRepository;
import tn.isetso.entities.Abonnement;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Facture;

import javax.transaction.Transactional;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Override
    public Facture createFacture(Abonnement abonnement, AbonnementData data) {

        if (abonnement==null) throw new RuntimeException("No abonnement found");
        if (data==null) throw new RuntimeException("No abonnement found");
        Entreprise entreprise = this.entrepriseRepository.getOne(data.getEntrepriseId());
        Facture facture = new Facture();
        facture.setAbonnement(abonnement);
        facture.setAddress(data.getAddress());
        facture.setCity(data.getCity());
        facture.setPaymentMethode(data.getPaymentMethode());
        facture.setPostal(data.getPostal());
        facture.setEntreprise(entreprise);
         this.factureRepository.save(facture);
        System.out.println(facture);
        return  null;
    }
}
