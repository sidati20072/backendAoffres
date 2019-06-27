package tn.isetso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.isetso.dao.FavorisRepository;
import tn.isetso.dao.OffreRepository;
import tn.isetso.dao.ViewRepository;
import tn.isetso.entities.Favoris;
import tn.isetso.entities.Membre;
import tn.isetso.entities.Offre;
import tn.isetso.entities.View;

import javax.transaction.Transactional;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {

	@Autowired
	private ViewRepository viewRepository;
	@Autowired
	private OffreRepository offreRepository;

	@Override
	public View incrementView(ViewData data) {

		View view = this.viewRepository.findByOffreID(data.getOffreId());
		if (view != null) {
			view.setCount(view.getCount() + 1);
			return view;
		}
		else
			{
				Offre offre = this.offreRepository.findById(data.getOffreId()).orElse(new Offre());
				View view1 = new View();
				view1.setOffre(offre);
				view1.setCount(1);
				this.viewRepository.save(view1);
				return view1;
		}

	}
}
