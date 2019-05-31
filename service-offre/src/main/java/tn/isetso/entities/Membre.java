package tn.isetso.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="user")
@Data
@ToString
@AllArgsConstructor
public class Membre {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String username; 
	private String password; 
	private String email;
	private String nom;
	private String prenom;
	private String civilite;
	private String fonction;
	
	
	
	public Membre(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public Membre() {
	}
	
	
}
