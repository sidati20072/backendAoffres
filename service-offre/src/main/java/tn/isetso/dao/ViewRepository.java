package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.Favoris;
import tn.isetso.entities.View;

import java.util.List;

@RepositoryRestResource
public interface ViewRepository extends JpaRepository<View, Long>{
	@Query("select v from View v where v.offre.id = ?1")
	public View findByOffreID (Long offreId);

}
