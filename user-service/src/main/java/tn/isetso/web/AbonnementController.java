package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.isetso.dao.*;
import tn.isetso.entities.*;
import tn.isetso.service.AbonnementData;
import tn.isetso.service.AccountService;
import tn.isetso.service.FactureService;
import tn.isetso.service.FormSimpleUser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@RestController
public class AbonnementController {
	@Autowired
	private FactureService factureService;
	@Autowired

	private PlanRepository planRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Autowired
		private FactureRepository factureRepository;

	@Autowired
	private AccountService accountService;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");



	@PostMapping("/abonnements/save")
		public Facture saveAbonnement(@RequestBody AbonnementData data){

		System.out.println(data.toString());

			Entreprise entreprise = entrepriseRepository.getOne(data.getEntrepriseId());
			Plan plan = planRepository.getOne(data.getPlanId());

			Abonnement abonnement = new Abonnement();
			abonnement.setEntreprise(entreprise);
			abonnement.setPlan(plan);
			abonnement.setPeriode(data.getPeriode());
			abonnement.setDateDebut(new Date());
			Date datefin = new Date();
			abonnement.setTotal(data.getTotal());
			abonnement.setRefpayment(data.getRefpayment());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, data.getPeriode());
			datefin = cal.getTime();
			abonnement.setDateFin(datefin);
			abonnementRepository.save(abonnement);
			entreprise.getAbonnements().add(abonnement);
			Facture facture = new Facture();
			facture.setPostal(data.getPostal());
			facture.setAbonnement(abonnement);
			facture.setEntreprise(entreprise);
			facture.setPaymentMethode(data.getPaymentMethode());

			return  factureRepository.save(facture);

		}
}
