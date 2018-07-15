package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Product;
import ru.projects.Shop.interfaces.local.ProductLocal;

@Stateless
@Local(ProductLocal.class)
@LocalBean
public class ProductEJB implements ProductLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllProduct", Product.class).getResultList();
	}

	@Override
	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Product.class, id);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		em.persist(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return em.merge(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		em.remove(em.merge(product));
	}

}
