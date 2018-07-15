package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Transportation;
import ru.projects.Shop.interfaces.local.TransportationLocal;

@Stateless
@Local(TransportationLocal.class)
@LocalBean
public class TransportationEJB implements TransportationLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Transportation> findAllTransportation() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllTransportation", Transportation.class).getResultList();
	}

	@Override
	public Transportation findTransportationById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Transportation.class, id);
	}

	@Override
	public Transportation createTransportation(Transportation transportation) {
		// TODO Auto-generated method stub
		em.persist(transportation);
		return transportation;
	}

	@Override
	public Transportation updateTransportation(Transportation transportation) {
		// TODO Auto-generated method stub
		return em.merge(transportation);
	}

	@Override
	public void deleteTransportation(Transportation transportation) {
		// TODO Auto-generated method stub
		em.remove(em.merge(transportation));
	}

}
