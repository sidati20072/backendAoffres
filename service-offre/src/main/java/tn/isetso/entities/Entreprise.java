package tn.isetso.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	
	public Entreprise() {
	} 
	
	
}
