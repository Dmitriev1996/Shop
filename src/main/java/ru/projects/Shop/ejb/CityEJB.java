package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.City;
import ru.projects.Shop.interfaces.local.CityLocal;

@Stateless
@Local(CityLocal.class)
@LocalBean
public class CityEJB implements CityLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllCity", City.class).getResultList();
	}

	@Override
	public City findCityById(Long id) {
		// TODO Auto-generated method stub
		return em.find(City.class, id);
	}

	@Override
	public City createCity(City city) {
		// TODO Auto-generated method stub
		em.persist(city);
		return city;
	}

	@Override
	public City updateCity(City city) {
		// TODO Auto-generated method stub
		return em.merge(city);
	}

	@Override
	public void deleteCity(City city) {
		// TODO Auto-generated method stub
		em.remove(em.merge(city));
	}

}
