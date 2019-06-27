package tn.isetso.services;

import org.springframework.http.HttpHeaders;
import tn.isetso.entities.Favoris;
import tn.isetso.entities.View;

public interface ViewService {

	public View incrementView(ViewData data);
}
