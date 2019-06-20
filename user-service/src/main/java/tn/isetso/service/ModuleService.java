package tn.isetso.service;

import tn.isetso.entities.Module;

public interface ModuleService {
    public Module doAction(Long idModule  , Long idEntreprise, String action );
}
