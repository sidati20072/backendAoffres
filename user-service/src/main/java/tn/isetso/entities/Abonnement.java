package tn.isetso.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
public class Abonnement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Integer periode;
    private Double total;
    private String details;
    private Date createAt;
    private String refpayment;

    @ManyToOne
    private Entreprise entreprise;

    @OneToOne
    private Plan plan;

    @OneToMany
    private List<Module> modules;

    public Abonnement() {
        this.createAt = new Date();
        this.modules = new ArrayList<Module>();
    }
}
