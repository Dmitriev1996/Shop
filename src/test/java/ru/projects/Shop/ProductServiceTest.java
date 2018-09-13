package ru.projects.Shop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.projects.Shop.entity.Product;

public class ProductServiceTest {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("test");
	private EntityManager em=emf.createEntityManager();
	
	@Test
	public void shouldProductService() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		TypedQuery<Product> query=em.createNamedQuery("findAllProduct", Product.class);
		List<Product> products=query.getResultList();
		String json=mapper.writeValueAsString(products);
		System.out.println(json);
	}

}
