package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Country;
import ru.projects.Shop.interfaces.local.CountryLocal;

@Stateless
@Local(CountryLocal.class)
@LocalBean
public class CountryEJB implements CountryLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Country> findAllCountry() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllCountry", Country.class).getResultList();
	}

	@Override
	public Country findCountryById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Country.class, id);
	}

	@Override
	public Country createCountry(Country country) {
		// TODO Auto-generated method stub
		em.persist(country);
		return country;
	}

	@Override
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		return em.merge(country);
	}

	@Override
	public void deleteCountry(Country country) {
		// TODO Auto-generated method stub
		em.remove(em.merge(country));
	}

}
