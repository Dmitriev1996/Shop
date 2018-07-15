package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.TypeShop;
import ru.projects.Shop.interfaces.local.TypeShopLocal;

@Stateless
@Local(TypeShopLocal.class)
@LocalBean
public class TypeShopEJB implements TypeShopLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<TypeShop> findAllTypeShop() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllTypeShop", TypeShop.class).getResultList();
	}

	@Override
	public TypeShop findTypeShopById(Long id) {
		// TODO Auto-generated method stub
		return em.find(TypeShop.class, id);
	}

	@Override
	public TypeShop createTypeShop(TypeShop typeshop) {
		// TODO Auto-generated method stub
		em.persist(typeshop);
		return typeshop;
	}

	@Override
	public TypeShop updateTypeShop(TypeShop typeshop) {
		// TODO Auto-generated method stub
		return em.merge(typeshop);
	}

	@Override
	public void deleteTypeShop(TypeShop typeshop) {
		// TODO Auto-generated method stub
		em.remove(em.merge(typeshop));
	}

}
