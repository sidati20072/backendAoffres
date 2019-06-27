package tn.isetso.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Facture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    private String address;
    private String city;
    private String postal;
    private String paymentMethode;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @RestResource(exported = false)
    private Abonnement abonnement;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @RestResource(exported = false)
    private Entreprise entreprise;

    public Facture() {
        this.createAt = new Date();
    }
}
