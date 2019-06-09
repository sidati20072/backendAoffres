package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isetso.entities.Config;
import tn.isetso.entities.Facture;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long > {

}
