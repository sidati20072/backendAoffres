package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.isetso.entities.Offre;

@RepositoryRestResource
public interface OffreRepository extends JpaRepository<Offre, Long> {

}
