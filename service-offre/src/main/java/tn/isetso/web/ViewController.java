package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tn.isetso.dao.ViewRepository;
import tn.isetso.entities.Favoris;
import tn.isetso.entities.View;
import tn.isetso.services.FavorisData;
import tn.isetso.services.FavorisService;
import tn.isetso.services.ViewData;
import tn.isetso.services.ViewService;

@RestController
public class ViewController {
	@Autowired
	private ViewService viewService;
	@PostMapping("/views/create")
	public View incrementView(@RequestBody ViewData data ) {

		if (data.getOffreId() == null) throw new RuntimeException("offreId required");
		return this.viewService.incrementView(data);
	}
}
