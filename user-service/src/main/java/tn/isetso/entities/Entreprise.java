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
	@OneToMany
	List<Membre> membres ;

	public Entreprise() {
		this.membres = new ArrayList<Membre>();
	} 
	
	
}
