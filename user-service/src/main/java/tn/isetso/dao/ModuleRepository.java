package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isetso.entities.Module;

@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module , Long> {
}
