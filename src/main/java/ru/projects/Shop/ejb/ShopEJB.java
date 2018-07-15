package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.interfaces.local.ShopLocal;

@Stateless
@Local(ShopLocal.class)
@LocalBean
public class ShopEJB implements ShopLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Shop> findAllShop() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllShop", Shop.class).getResultList();
	}

	@Override
	public Shop findShopById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Shop.class, id);
	}

	@Override
	public Shop createShop(Shop shop) {
		// TODO Auto-generated method stub
		em.persist(shop);
		return shop;
	}

	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return em.merge(shop);
	}

	@Override
	public void deleteShop(Shop shop) {
		// TODO Auto-generated method stub
		em.remove(em.merge(shop));
	}

}
