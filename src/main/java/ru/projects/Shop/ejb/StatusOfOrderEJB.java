package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.StatusOfOrder;
import ru.projects.Shop.interfaces.local.StatusOfOrderLocal;

@Stateless
@Local(StatusOfOrderLocal.class)
@LocalBean
public class StatusOfOrderEJB implements StatusOfOrderLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<StatusOfOrder> findAllStatusOfOrder() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllStatus", StatusOfOrder.class).getResultList();
	}

	@Override
	public StatusOfOrder findStatusOfOrderById(Long id) {
		// TODO Auto-generated method stub
		return em.find(StatusOfOrder.class, id);
	}

	@Override
	public StatusOfOrder createStatusOfOrder(StatusOfOrder status) {
		// TODO Auto-generated method stub
		em.persist(status);
		return status;
	}

	@Override
	public StatusOfOrder updateStatusOfOrder(StatusOfOrder status) {
		// TODO Auto-generated method stub
		return em.merge(status);
	}

	@Override
	public void deleteStatusOfOrder(StatusOfOrder status) {
		// TODO Auto-generated method stub
		em.remove(em.merge(status));
	}

}
