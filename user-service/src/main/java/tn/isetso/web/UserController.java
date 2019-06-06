package tn.isetso.web;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.isetso.dao.EntrepriseRepository;
import tn.isetso.dao.MembreRepository;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;
import tn.isetso.service.AccountService;
import tn.isetso.service.FormSimpleUser;

@RestController
public class UserController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@PostMapping("/invite")
	public Membre signUp(@RequestBody FormSimpleUser data) {
		String email=data.getEmail();
		Membre user = accountService.findUserByEmail(email);
		if (user!=null) throw new RuntimeException("This user already exist");
		
		user = accountService.saveUser(data);
		return  user;
		}
	

	
	//creation user et entreprise 
	@PostMapping("/create_entreprise")
	public Membre createUsers(@RequestBody RegistrationData data) {
		System.out.println(data.toString());
		Membre u = new Membre() ; 
		u.setUsername(data.getEmail());
		u.setEmail(data.getEmail());
		u.setNom(data.getNom());
		u.setPrenom(data.getPrenom());
		u.setFonction(data.getFonction());
		u.setPassword(data.getPassword());
		u.setCivilite(data.getCivilite());

		Entreprise entreprise  = new Entreprise(); 
		entreprise.setNom(data.getNomentreprise());
		entreprise.setAddress(data.getAddressentreprise());
		entreprise.setLogo(data.getLogo());
		entreprise.setEmail(data.getEmailentreprise());
		entreprise.setEmail(data.getTelentreprise());
		entreprise.setEmail(data.getSecteurentreprise());
		//accountService.createEntreprise(u , entreprise) ;
		
		return accountService.createEntreprise(u , entreprise) ; 
		}
	
	
	
	//creation user et entreprise 
		@PostMapping("/create_fournisseur")
		public Membre createFournisseur(@RequestBody RegistrationData data) {
			System.out.println(data.toString());
			Membre u = new Membre() ; 
			u.setUsername(data.getEmail());
			u.setEmail(data.getEmail());
			u.setNom(data.getNom());
			u.setPrenom(data.getPrenom());
			u.setFonction(data.getFonction());
			u.setPassword(data.getPassword());
			u.setCivilite(data.getCivilite());
			u.setTel(data.getTel());
			
			return accountService.createFournisseur(u) ; 
			}
		
		
}
