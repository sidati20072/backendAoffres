package tn.isetso.services;

import tn.isetso.entities.Demande;

import java.util.List;
import java.util.Map;

public interface DemandeService {

public Demande addDemande(Long idOffre , DemandeData data);
public Map<String, String> demandeAction(ActionDTO action);
public List<Demande> findAll();
}
