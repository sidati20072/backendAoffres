package tn.isetso.services;

import org.springframework.http.HttpHeaders;

import tn.isetso.entities.Favoris;

public interface FavorisService {

	public Favoris addFavoris(FavorisData favorisdata , HttpHeaders header);
}
