package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isetso.entities.Config;

@RepositoryRestResource
public interface ConfigRepository  extends JpaRepository<Config , Long > {

}
