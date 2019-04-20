package tn.isetso;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.isetso.dao.RoleRepository;
import tn.isetso.dao.MembreRepository;
import tn.isetso.entities.Role;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
import tn.isetso.service.AccountService;

@EnableDiscoveryClient
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner{

@Autowired 
private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Membre.class,Entreprise.class);
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

 