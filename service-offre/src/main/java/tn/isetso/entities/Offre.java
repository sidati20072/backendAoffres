package tn.isetso.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor

public class Offre {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String objet;
	private String type;
	private String description;
	private Date dateLimite;
	private Date dateExecution;
	private String Address;
	private String Address2;
	private String city;
	private String pays;
	private Date createAt;
	@ManyToOne
	private Membre membre;
	@ManyToOne
	private Entreprise entreprise;
	
	@ManyToMany( mappedBy="offres" , cascade= CascadeType.ALL)
	@RestResource(exported = false)
	private List<Category> categories;

	@OneToMany(mappedBy = "offre")
	@JsonIgnoreProperties("offre")
	@JsonIgnore
	@RestResource(exported = false)
	private List<Demande> demandes;

	public Offre() {
		this.createAt = new Date();
		this.categories = new ArrayList<Category>();
		this.demandes = new ArrayList<Demande>();
			
	}
	
	
	
}
