package tn.isetso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isetso.dao.EntrepriseRepository;
import tn.isetso.dao.ModuleRepository;
import tn.isetso.entities.Entreprise;
import tn.isetso.entities.Module;

import javax.transaction.Transactional;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public Module doAction(Long idModule, Long idEntreprise, String action) {
        Entreprise entreprise = this.entrepriseRepository.getOne(idEntreprise);
        Module module = this.moduleRepository.getOne(idModule);
        if (action.equals("install")){
            entreprise.getModules().add(module);
        }else {

            entreprise.getModules().remove(module);
        }

        return module;

    }
}
