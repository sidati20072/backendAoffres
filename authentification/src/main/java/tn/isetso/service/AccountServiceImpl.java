package tn.isetso.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.isetso.dao.RoleRepository;
import tn.isetso.dao.UserRepository;
import tn.isetso.entities.Role;
import tn.isetso.entities.Users;
import tn.isetso.web.RegistrationForm;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public Users saveUser(RegistrationForm data) {
		String type=data.getTypecreation(); 
		Users u = new Users();
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
		emailService.sendAccountInformation(u, password);
		this.addRoleToUser(u.getUsername(), "USER");


		return u;
	}

	@Override
	public Role saveRole(Role r) {

		return roleRepository.save(r);
	}

	@Override
	public Users findUserByUsername(String username) {

		return userRepository.findByUsername(username);
	}
	
	@Override
	public Users findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}


	@Override
	public void addRoleToUser(String username, String roleName) {
		
		Users user=userRepository.findByUsername(username);
		Role role=roleRepository.findByRole(roleName);
		user.getRoles().add(role);
	}

	
	
	private String passwordGenerator() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random( 15, characters );
		return pwd;
	}
}
