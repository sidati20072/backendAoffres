package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.isetso.entities.Demande;
@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<Demande, Long>{

}
