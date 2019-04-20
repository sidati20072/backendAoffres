package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.isetso.entities.Entreprise;

@RepositoryRestResource
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
