package tn.isetso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.DemandeRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;

@Service
@Transactional	
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	private OffreRepository offreRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Override
	public Demande addDemande(Long idOffre, DemandeData data) {
		
		Offre offre= offreRepository.getOne(idOffre);
		System.out.println(offre);
		Date dateExecution=null;
		try {
			dateExecution = new SimpleDateFormat("dd/MM/yyyy").parse(data.getDateExecution());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate =new RestTemplate();
		Membre membre = restTemplate.getForObject("http://localhost:8180/membres/{id}", Membre.class, data.getUserId());

		Demande demande = new Demande(null, new Date(), dateExecution, data.getDuree(), data.getDescription(), data.getTarif(), "pending", data.getDevis(), membre, offre);
		
		System.out.println(demande);
		try {
			demandeRepository.save(demande);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return demande;
	}

	@Override
	public Map<String, String> demandeAction(ActionDTO action) {
		Demande demande = this.demandeRepository.getOne(action.getDemandeId());

		if (demande == null) throw new RuntimeException("demande invalid");

		if (action.getAction().equals("accept")) {
			demande.setEtat("accepted");
		} else if (action.getAction().equals("refuse")) {
			demande.setEtat("refused");
		} else throw new RuntimeException("action invalid");


		return Collections.singletonMap("response", "demande a été " + action.getAction());

		}

	@Override
	public List<Demande> findAll() {

		return demandeRepository.findAll();
	}


}
