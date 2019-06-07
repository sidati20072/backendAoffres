package tn.isetso.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@ToString
public class Plan {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private Date createAt;
    private Double prix;
    private String description;

    public Plan() {
        this.createAt = new Date();
    }
}
