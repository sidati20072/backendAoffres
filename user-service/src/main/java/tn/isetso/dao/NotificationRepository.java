package tn.isetso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tn.isetso.entities.Config;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Notification;

import java.util.List;

@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, Long > {
    @RestResource(path="/findByLastNotification")
    @Query("select n from Notification n ORDER BY n.id desc ")
    public List<Notification> find();

}
