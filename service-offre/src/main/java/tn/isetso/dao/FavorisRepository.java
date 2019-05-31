package tn.isetso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.isetso.entities.Favoris;
@RepositoryRestResource
public interface FavorisRepository extends JpaRepository<Favoris, Long>{
	@RestResource(path="/findByMembreAndOffre")
	  @Query("select f from Favoris f where f.membre.id = ?1 and f.offre.id = ?2")
	public Favoris searchByMembreAndOffre(Long membreId , Long offreId);
	
	@RestResource(path="/findByMembre")
	  @Query("select f from Favoris f where f.membre.id = ?1")
	public List<Favoris> searchByMembre(Long membreId);
	
}
