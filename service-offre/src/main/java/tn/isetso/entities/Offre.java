package tn.isetso.entities;

import java.util.ArrayList;
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
	
	@ManyToMany(fetch=FetchType.EAGER , mappedBy="offres" , cascade= CascadeType.ALL)
	private List<Category> categories;

	 @OneToMany(mappedBy="offre" )
     private List<Demande> demandes;

	public Offre() {
		this.categories = new ArrayList<Category>();
		this.demandes = new ArrayList<Demande>();
			
	}
	
}
