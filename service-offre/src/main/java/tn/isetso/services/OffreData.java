package tn.isetso.services;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tn.isetso.entities.Demande;
import tn.isetso.entities.Offre;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OffreData {
	private String objet;
	private String type;
	private String description;
	private String dateLimite;
	private String dateExecution;
	private String Address;
	private String city;
	private String pays;
	private Long categorie;
	private Long entreprise;
	private Long user;
}
