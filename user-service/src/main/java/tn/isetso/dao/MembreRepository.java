package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.isetso.entities.Membre;

@RepositoryRestResource
public interface MembreRepository  extends JpaRepository<Membre, Long>{

	public Membre findByUsername(String username);
	public Membre findByEmail(String email);
}
