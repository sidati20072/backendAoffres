package tn.isetso.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
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
	private String etat;
	private String devis;

	@ManyToOne
    @JoinColumn(name = "user_id")
	private Membre membre;

	@ManyToOne
	@JsonIgnoreProperties("demandes")
	@RestResource(exported = false)
	private Offre offre;

	@Override
	public String toString() {
		return "Demande{" +
				"id=" + id +
				", createAt=" + createAt +
				", dateExecution=" + dateExecution +
				", duree=" + duree +
				", description='" + description + '\'' +
				", tarif=" + tarif +
				", etat='" + etat + '\'' +
				", devis='" + devis + '\'' +
				'}';
	}
}
