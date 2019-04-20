package tn.isetso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.isetso.dao.DemandeRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Demande;
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
		Demande demande = new Demande(null, new Date(), dateExecution, data.getDuree(), data.getDescription(), data.getTarif(), false, data.getDevis(), offre);		
		demandeRepository.save(demande);
		
		return demande;
	}

	
}
