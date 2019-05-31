package tn.isetso;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.client.RestTemplate;

import tn.isetso.dao.DemandeRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Category;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceOffreApplication implements CommandLineRunner{

	@Autowired
	private OffreRepository offreRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
@Autowired 
private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ServiceOffreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Category.class,Entreprise.class,Demande.class,Offre.class);
		/*if (roleRepository.findByRole("USER")==null) {
			Role r = new Role();		r.setRole("USER");
			roleRepository.save(r);
		}
		

		if (roleRepository.findByRole("ADMIN")==null) {
			Role r = new Role();		r.setRole("ADMIN");
			roleRepository.save(r);
		}
		Offre offre= offreRepository.getOne(1L);
		RestTemplate restTemplate =new RestTemplate();
		Membre membre = restTemplate.getForObject("http://localhost:8180/membres/{id}", Membre.class, 1);


		for (int i = 0 ; i<10 ; i++) {
			Demande demande = new Demande(null, new Date(), null, 2, "jgjhg", (double) 5454, false, "up", membre, offre);		
			demandeRepository.save(demande);
		}
		*/
	}
}
