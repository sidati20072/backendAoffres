package tn.isetso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    private String type;
    private String message;
    private Long idResource;
    @ManyToOne
    @RestResource(exported = false)
    private Membre membre;

    public Notification() {
        this.createAt = new Date();
    }
}
