package tn.isetso.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private Date createAt;
	private Date dateExecution;
	private Integer duree;
	private String description;
	private Double tarif; 
	private Boolean etat;
	private String devis;
	
    @ManyToOne(fetch=FetchType.EAGER)
	private Offre offre;
	
	

}
