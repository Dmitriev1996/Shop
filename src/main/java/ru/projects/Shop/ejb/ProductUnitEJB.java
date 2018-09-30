package ru.projects.Shop.ejb;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.ProductUnit;
import ru.projects.Shop.interfaces.local.ProductUnitLocal;

public class ProductUnitEJB implements ProductUnitLocal {
	
	@Inject
	private EntityManager em;

	@Override
	public List<ProductUnit> findAllProductUnits() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllProductUnit", ProductUnit.class)
				.getResultList();
	}

	@Override
	public ProductUnit findProductUnitById(Long id) {
		// TODO Auto-generated method stub
		return em.find(ProductUnit.class, id);
	}

	@Override
	public ProductUnit createProductUnit(ProductUnit productUnit) {
		// TODO Auto-generated method stub
		em.persist(productUnit);
		return productUnit;
	}

	@Override
	public ProductUnit updateProductUnit(ProductUnit productUnit) {
		// TODO Auto-generated method stub
		return em.merge(productUnit);
	}

	@Override
	public void deleteProductUnit(ProductUnit productUnit) {
		// TODO Auto-generated method stub
		em.remove(em.merge(productUnit));
	}

}
