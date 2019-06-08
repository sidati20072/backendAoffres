package tn.isetso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Config {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String presentation;
    private String logo;
    private String titre;
    private String langue;
    private String mode;

}
