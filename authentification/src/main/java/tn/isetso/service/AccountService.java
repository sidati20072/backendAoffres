package tn.isetso.service;

import tn.isetso.entities.Role;
import tn.isetso.entities.Users;
import tn.isetso.web.RegistrationForm;

public interface AccountService {

	public Users saveUser(RegistrationForm data);
	public Role saveRole(Role r);
	public Users findUserByUsername(String username);
	public Users findUserByEmail(String email);
	public void addRoleToUser(String username , String roole);
	
}
