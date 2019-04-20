package tn.isetso.service;

import java.util.List;

import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Role;
import tn.isetso.entities.Membre;
import tn.isetso.web.RegistrationData;

public interface AccountService {

	//public Users saveUser(RegistrationData data);
	public Role saveRole(Role r);
	public Membre findUserByUsername(String username);
	public Membre findUserByEmail(String email);
	public void addRoleToUser(String username , String roole);
	public Membre createEntreprise(Membre u , Entreprise e);
	public Membre saveUser(FormSimpleUser data);
	public List<Membre> getUsers();
}
