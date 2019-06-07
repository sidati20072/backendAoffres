package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isetso.entities.Plan;

@RepositoryRestResource
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
