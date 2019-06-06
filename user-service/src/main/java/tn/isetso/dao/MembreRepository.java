package tn.isetso.dao;

import java.util.List;
import tn.isetso.entities.Membre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
public interface MembreRepository  extends JpaRepository<Membre, Long>{
	//@RestResource(path="/findByUsername")@Param("username")
	public Membre findByUsername( String username);
	
	public Membre findByEmail(String email);
	
	@RestResource(path="/findByEntreprise")
	  @Query("select m from user m where m.entreprise.id = ?1")
	public List<Membre> searchByEntreprise(Long entrepriseId);


	@RestResource(path="/findByLogin")
	public List<Membre> findMembreByUsernameEquals(String username);
}
