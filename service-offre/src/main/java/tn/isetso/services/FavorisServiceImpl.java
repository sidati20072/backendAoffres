package tn.isetso.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.FavorisRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Favoris;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;
@Service
@Transactional
public class FavorisServiceImpl implements FavorisService {

	@Autowired 
	private OffreRepository offreRepository;

	@Autowired 
	private FavorisRepository favorisRepository;

	@Override
	public Favoris addFavoris(FavorisData favorisdata, HttpHeaders header) {
		// TODO Auto-generated method stub
		Favoris favoris = new Favoris(); 
		RestTemplate restTemplate = new RestTemplate();

		Membre membre = restTemplate.getForObject("http://localhost:8180/membres/{id}", Membre.class, favorisdata.getUserId());
		Offre offre = offreRepository.findById( Long.valueOf(favorisdata.getOffreId())).orElse(null);
		if (membre==null) throw new RuntimeException("membre n'existe pas");
		if ( offre ==null ) throw new RuntimeException("offre n'existe pas");
		
		favoris.setMembre(membre);
		
		favoris.setOffre(offre);
		this.favorisRepository.save(favoris);
		
		if (favoris == null) throw new RuntimeException("erreur favoris");
		
		return favoris;
	}

}
