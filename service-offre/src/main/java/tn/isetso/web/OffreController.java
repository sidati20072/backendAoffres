package tn.isetso.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.isetso.dao.CategoryRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.entities.Category;
import tn.isetso.entities.Offre;
@RestController

public class OffreController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private OffreRepository offreRepository;
	
	@GetMapping("/test")
	public List<Offre> test() {
		Category c = new Category();
		c.setNom("testCat");
		categoryRepository.save(c);
		
		Offre o = new Offre();
		o.setObjet("test Objet");
		o.setDateExecution(new Date());
		o.getCategories().add(c);
		offreRepository.save(o);
		
		return offreRepository.findAll();
		}
		
}
	
	
	

