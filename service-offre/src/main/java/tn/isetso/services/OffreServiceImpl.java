package tn.isetso.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.CategoryRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Category;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;

@Service
@Transactional
public class OffreServiceImpl implements OffreService{
	
	@Autowired 
	private OffreRepository offreRepository;
	@Autowired
	private CategoryRepository categorieRepository;
	
	@Override
	public Offre createOffre(OffreData offreData, HttpHeaders header) {
		Date dateExecution=new Date() , dateLimite=new Date();
		RestTemplate restTemplate =new RestTemplate();
		try {
			dateExecution = new SimpleDateFormat("dd/MM/yyyy").parse(offreData.getDateExecution());
			dateLimite = new SimpleDateFormat("dd/MM/yyyy").parse(offreData.getDateExecution());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category categorie = this.categorieRepository.findById(offreData.getCategorie()).orElse(null);
		//HttpEntity<Membre> request = new HttpEntity<Membre>(customerBean, headers);
		Membre membre = restTemplate.getForObject("http://localhost:8180/membres/{id}", Membre.class, offreData.getUser());
		Entreprise entreprise = restTemplate.getForObject("http://localhost:8180/entreprises/{id}", Entreprise.class, offreData.getEntreprise());	
		List<Category> categories = new ArrayList<Category>();
		categories.add(categorie);
		Offre offre = new Offre();
		offre.setObjet(offreData.getObjet());
		offre.setType(offreData.getType());
		offre.setDescription(offreData.getDescription());
		offre.setDateLimite(dateLimite);
		offre.setDateExecution(dateExecution);
		offre.setAddress(offreData.getAddress());
		offre.setCity(offreData.getCity());
		offre.setPays(offreData.getPays());
	
		this.offreRepository.save(offre);
		offre.setMembre(membre);
		offre.setEntreprise(entreprise);
		offre.setCategories(categories);
		
		return offre; 
	}

}
