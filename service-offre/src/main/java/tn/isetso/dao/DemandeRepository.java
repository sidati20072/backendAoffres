package tn.isetso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.isetso.entities.Demande;
import tn.isetso.entities.Favoris;
@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<Demande, Long>{

	@RestResource(path="/findByMembre")
	  @Query("select d from Demande d where membre.id = ?1")
	public List<Demande> searchByMembre(Long membreId);


	@RestResource(path="/findByOffre")
	@Query("select d from Demande d where offre.id = ?1")
	public List<Demande> searchByOffre(Long offreId);

}

