package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.isetso.entities.Membre;

@RepositoryRestResource
public interface MembreRepository  extends JpaRepository<Membre, Long>{
	//@RestResource(path="/findByUsername")@Param("username")
	public Membre findByUsername( String username);
	
	public Membre findByEmail(String email);
}
