package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Delivery;
import ru.projects.Shop.interfaces.local.DeliveryLocal;

@Stateless
@Local(DeliveryLocal.class)
@LocalBean
public class DeliveryEJB implements DeliveryLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Delivery> findAllDelivery() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllDelivery", Delivery.class).getResultList();
	}

	@Override
	public Delivery findDeliveryById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Delivery.class, id);
	}

	@Override
	public Delivery createDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		em.persist(delivery);
		return delivery;
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return em.merge(delivery);
	}

	@Override
	public void deleteDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		em.remove(em.merge(delivery));
	}

}
