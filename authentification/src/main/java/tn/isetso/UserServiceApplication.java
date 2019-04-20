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
import tn.isetso.dao.TaskRepository;
import tn.isetso.dao.UserRepository;
import tn.isetso.entities.Role;
import tn.isetso.entities.Task;
import tn.isetso.entities.Users;
import tn.isetso.service.AccountService;

@EnableDiscoveryClient
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner{

	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired 
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Role r = new Role();
		Role r2 = new Role();

		r.setRole("USER");
		r2.setRole("ADMIN");
		roleRepository.save(r);
		roleRepository.save(r2);

		}

	
}

 