package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;

import ru.projects.Shop.ejb.TypeProductEJB;
import ru.projects.Shop.entity.TypeProduct;
import ru.projects.Shop.entity.TypeProducts;

public class TypeProductTest extends ParentTest {
	
	@Inject
	private EntityManager em;
	
	@Test
	public void shouldTypeProduct() throws Exception {
		TypedQuery<TypeProduct> query=em.createNamedQuery("findAllTypeProduct", TypeProduct.class);
		TypeProducts typeProducts=new TypeProducts(query.getResultList());
		assertEquals(8, typeProducts.size());
	}

}
