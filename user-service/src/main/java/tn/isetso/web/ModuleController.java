package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.isetso.dao.*;
import tn.isetso.entities.*;
import tn.isetso.service.AccountService;
import tn.isetso.service.FactureService;
import tn.isetso.service.FormSimpleUser;
import tn.isetso.service.ModuleService;
import tn.isetso.service.ModuleData;
import java.util.Date;

@RestController
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@PostMapping("/modules/action")
	public Module moduleAction(@RequestBody ModuleData data) {
		if (data == null) throw new RuntimeException("data required");
		Module module =  moduleService.doAction(data.getModuleId(),data.getEntrepriseId(),data.getAction());
		return null;
	}
	

}
