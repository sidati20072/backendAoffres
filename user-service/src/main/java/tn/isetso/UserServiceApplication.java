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

import tn.isetso.dao.ConfigRepository;
import tn.isetso.dao.RoleRepository;
import tn.isetso.dao.MembreRepository;
import tn.isetso.entities.Role;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
import tn.isetso.service.AccountService;
import tn.isetso.entities.Module;
import tn.isetso.entities.Plan;
import tn.isetso.entities.Config;

@EnableDiscoveryClient
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner{

@Autowired 
private RepositoryRestConfiguration repositoryRestConfiguration;

@Autowired
private RoleRepository roleRepository;
@Autowired
private ConfigRepository configRepository;

public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Membre.class,Entreprise.class,Module.class,Plan.class,Config.class);

		if (roleRepository.findByRole("USER")==null) {
			Role r = new Role();		r.setRole("USER");
			roleRepository.save(r);
		}

		if (roleRepository.findByRole("ADMIN")==null) {
			Role r = new Role();		r.setRole("ADMIN");
			roleRepository.save(r);
		}

		if (roleRepository.findByRole("FOURNISSEUR")==null) {
			Role r = new Role();		r.setRole("FOURNISSEUR");
			roleRepository.save(r);
		}

		if (roleRepository.findByRole("SUPER")==null) {
			Role r = new Role();		r.setRole("SUPER");
			roleRepository.save(r);
		}

		if (configRepository.findById(1L).orElse(null)==null) {
			Config config = new Config();
			config.setLangue("francais");
			config.setTitre("default title");
			configRepository.save(config);
		}



		}

}

 
