package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isetso.entities.Abonnement;
import tn.isetso.entities.Config;

@RepositoryRestResource
public interface AbonnementRepository extends JpaRepository<Abonnement, Long > {

}
