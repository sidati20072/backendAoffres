package tn.isetso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.isetso.entities.Favoris;
import tn.isetso.entities.Membre;
import tn.isetso.services.FavorisData;
import tn.isetso.services.FavorisService;
import tn.isetso.services.OffreService;

@RestController
public class FavorisController {
	@Autowired
	private FavorisService favorisService;
	
	@PostMapping("/favorises")
	public Favoris addFavoris(@RequestBody FavorisData data  , RestTemplate restTemplate ,  @RequestHeader HttpHeaders headers) {
						
		return  favorisService.addFavoris(data, headers);
		}	
}
