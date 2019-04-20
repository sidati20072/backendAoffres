package tn.isetso.services;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.isetso.entities.Category;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Offre;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data

public class DemandeData {

	private Date createAt;
	private String dateExecution;
	private Integer duree;
	private String description;
	private Double tarif; 
	private Boolean etat;
	private String devis;
	private String offreId; 
}
