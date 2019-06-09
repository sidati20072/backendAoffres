package tn.isetso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isetso.dao.AbonnementRepository;
import tn.isetso.dao.EntrepriseRepository;
import tn.isetso.dao.ModuleRepository;
import tn.isetso.dao.PlanRepository;
import tn.isetso.entities.Abonnement;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Facture;
import tn.isetso.entities.Plan;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class AbonnementServiceImpl implements AbonnementService{

    @Autowired
    private FactureService factureService;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Override
    public Facture createAbonnement(AbonnementData data) {
        Date dateDebut = new Date() ,dateFin= new Date();
        if (data==null) throw new RuntimeException("data required");
        Entreprise entreprise = entrepriseRepository.getOne(data.getEntrepriseId());
        Plan plan = planRepository.getOne(data.getPlanId());

        Abonnement abonnement = new Abonnement();
        try {
            dateDebut = new SimpleDateFormat("dd/MM/yyyy").parse(data.getDateDebut());
            dateFin = new SimpleDateFormat("dd/MM/yyyy").parse(data.getDateFin());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        abonnement.setDateDebut(dateDebut);
        abonnement.setDateFin(dateFin);
        abonnement.setDetails(data.getDetails());
        abonnement.setPeriode(data.getPeriode());
        abonnement.setRefpayment(data.getRefpayment());
        abonnement.setPlan(plan);
        abonnement.setEntreprise(entreprise);
        abonnement.setTotal(data.getTotal());
        this.abonnementRepository.save(abonnement);

        return this.factureService.createFacture(abonnement , data);

    }
}
