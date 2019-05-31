package tn.isetso.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.isetso.dao.EntrepriseRepository;
import tn.isetso.dao.RoleRepository;
import tn.isetso.dao.MembreRepository;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Role;
import tn.isetso.entities.Membre;
import tn.isetso.web.RegistrationData;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private MembreRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Override
	public Membre saveUser(FormSimpleUser data) {
		String type=data.getTypecreation(); 
		Membre u = new Membre();
		String password = this.passwordGenerator() ; 
			u.setUsername(data.getEmail());u.setEmail(data.getEmail());u.setPassword(password);
			u.setPassword(bcryptPasswordEncoder.encode(u.getPassword()));
			//Role r = roleRepository.findByRole("USER");
			//u.getRoles().add(r);
			if (userRepository.save(u)!=null) {
				this.addRoleToUser(u.getUsername(), "USER");
				this.addUserToEntreprise(u.getUsername(), data.getEntreprise());
				emailService.sendAccountInformation(u, password);
				System.out.println("success"); 	
				System.out.println(u);
			}
			else System.out.println("echec");
			
		
		return u;
	}

	@Override
	public Role saveRole(Role r) {

		return roleRepository.save(r);
	}

	@Override
	public Membre findUserByUsername(String username) {

		return userRepository.findByUsername(username);
	}
	
	@Override
	public Membre findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}


	@Override
	public void addRoleToUser(String username, String roleName) {
		
		Membre user=userRepository.findByUsername(username);
		Role role=roleRepository.findByRole(roleName);
		user.getRoles().add(role);
	}

	@Override
	public void addUserToEntreprise(String username, Long idEntreprise) {
		
		Membre user=userRepository.findByUsername(username);
		Entreprise e = this.entrepriseRepository.findById(idEntreprise).orElse(null);
		if (e==null) throw new RuntimeException("entreprise not found");
		user.setEntreprise(e);
	}

	

	private String passwordGenerator() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random( 15, characters );
		return pwd;
	}

	@Override
	public Membre createEntreprise(Membre user , Entreprise entreprise) {
			if (userRepository.findByEmail(user.getEmail())!=null || userRepository.findByUsername(user.getEmail())!=null) {
				throw new RuntimeException("This user already exist");		}
		
		entrepriseRepository.save(entreprise);
		
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		user.setEntreprise(entreprise);
		user.getRoles().add(roleRepository.findByRole("ADMIN"));
		user.getRoles().add(roleRepository.findByRole("USER"));
		return user;
	}

	@Override
	public List<Membre> getUsers() {
		
		return this.userRepository.findAll();
		
	}
	

	@Override
	public Membre createFournisseur(Membre user) {
			if (userRepository.findByEmail(user.getEmail())!=null || userRepository.findByUsername(user.getEmail())!=null) {
				throw new RuntimeException("This user already exist");		}
				
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);

		user.getRoles().add(roleRepository.findByRole("FOURNISSEUR"));
		return user;
	}

}
