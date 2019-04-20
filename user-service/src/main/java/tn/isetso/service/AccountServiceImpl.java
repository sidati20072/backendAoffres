package tn.isetso.service;

import java.util.List;

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
		if (type.equals("email")) {
		u.setUsername(data.getEmail());u.setEmail(data.getEmail());u.setPassword(password);
		
		}
		else {
			u.setEmail(data.getEmail());
			u.setUsername(data.getUsername());
			u.setPassword(data.getPassword());
		}
		u.setPassword(bcryptPasswordEncoder.encode(u.getPassword()));
		userRepository.save(u);
		u.getRoles().add(roleRepository.findByRole("USER"));
		emailService.sendAccountInformation(u, password);

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

	
	
	private String passwordGenerator() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random( 15, characters );
		return pwd;
	}

	@Override
	public Membre createEntreprise(Membre user , Entreprise entreprise) {
			if (userRepository.findByEmail(user.getEmail())!=null || userRepository.findByUsername(user.getEmail())!=null) {
			return null;
		}
		
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
	
	
	
}
