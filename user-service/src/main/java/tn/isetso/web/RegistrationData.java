package tn.isetso.web;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationData {

	public String username ; 
	public String password ; 
	public String email ; 
	public String nom ; 
	public String prenom ; 
	public String civilite ; 
	public String fonction ; 
	public String role ; 
	public String nomentreprise ; 
	public String addressentreprise ; 
	public String logo ;
	public RegistrationData(String username, String password, String email, String nom, String prenom, String civilite,
			String fonction, String role, String nomentreprise, String addressentreprise, String logo) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.fonction = fonction;
		this.role = role;
		this.nomentreprise = nomentreprise;
		this.addressentreprise = addressentreprise;
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "RegstrationData [username=" + username + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", civilite=" + civilite + ", fonction=" + fonction + ", role=" + role
				+ ", nomentreprise=" + nomentreprise + ", addressentreprise=" + addressentreprise + ", logo=" + logo
				+ "]";
	} 



}
