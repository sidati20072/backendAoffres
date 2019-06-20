package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.Config;
import tn.isetso.entities.Facture;
import tn.isetso.entities.Membre;

import java.util.List;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long > {
    @RestResource(path="/findByEntreprise")
    @Query("select f from Facture f where f.entreprise.id = ?1")
    public List<Facture> searchByEntreprise(Long entrepriseId);

}
