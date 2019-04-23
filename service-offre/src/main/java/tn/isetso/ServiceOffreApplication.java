package tn.isetso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import tn.isetso.entities.Category;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceOffreApplication implements CommandLineRunner{

@Autowired 
private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ServiceOffreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Category.class,Entreprise.class);
		/*if (roleRepository.findByRole("USER")==null) {
			Role r = new Role();		r.setRole("USER");
			roleRepository.save(r);
		}
		

		if (roleRepository.findByRole("ADMIN")==null) {
			Role r = new Role();		r.setRole("ADMIN");
			roleRepository.save(r);
		}*/
		
		}
}
