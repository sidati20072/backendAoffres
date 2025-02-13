package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Membre;

import java.util.List;

@RepositoryRestResource
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    @RestResource(path="/findByLastEntreprises")
    @Query("select e from Entreprise e ORDER BY e.id desc ")
    public List<Entreprise> find();
}
