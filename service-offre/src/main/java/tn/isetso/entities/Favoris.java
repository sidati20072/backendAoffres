package tn.isetso.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
public class Favoris {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date createAt;
	@ManyToOne
	private Membre membre; 
	@ManyToOne
	@RestResource(exported = false)
	private Offre offre;
	
	
	public Favoris() {
		this.createAt = new Date();
	}
}
