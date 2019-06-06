package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.Offre;

import java.util.List;

@RepositoryRestResource
public interface OffreRepository extends JpaRepository<Offre, Long> {

    @RestResource(path="/findByEntreprise")
    @Query("select f from Offre f where f.entreprise.id = ?1")
     List<Offre> searchByMembre(Long entrepriseId);
}
