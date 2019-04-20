package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.isetso.entities.Users;

@RepositoryRestResource
public interface UserRepository  extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
	public Users findByEmail(String email);
}
