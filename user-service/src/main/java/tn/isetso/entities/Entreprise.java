package tn.isetso.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor

public class Entreprise {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String nom; 
	private String address;
	private String logo;
	private Date createAt;
	private String email;
	private String tel;
	private String secteur;

	@OneToMany
	private List<Membre> membres ;

	@OneToMany
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private List<Abonnement> abonnements ;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	@OneToMany(mappedBy = "entreprise")
	private List<Facture> factures;

	public Entreprise() {
		this.factures = new ArrayList<Facture>();
		this.membres = new ArrayList<Membre>();
		this.abonnements = new ArrayList<Abonnement>();
		this.createAt = new Date();
	}
	
	
}
