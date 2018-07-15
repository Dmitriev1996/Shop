package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Buy;
import ru.projects.Shop.interfaces.local.BuyLocal;

@Stateless
@Local(BuyLocal.class)
@LocalBean
public class BuyEJB implements BuyLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Buy> findAllBuy() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllBuy", Buy.class).getResultList();
	}

	@Override
	public Buy findBuyById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Buy.class, id);
	}

	@Override
	public Buy createBuy(Buy buy) {
		// TODO Auto-generated method stub
		em.persist(buy);
		return buy;
	}

	@Override
	public Buy updateBuy(Buy buy) {
		// TODO Auto-generated method stub
		return em.merge(buy);
	}

	@Override
	public void deleteBuy(Buy buy) {
		// TODO Auto-generated method stub
		em.remove(em.merge(buy));
	}

}
