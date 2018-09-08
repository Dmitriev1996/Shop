package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.ProductEJB;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.TypeProduct;

public class ProductTest extends ParentTest {
	
	@Test
	public void shouldProduct() throws Exception {
		Product product=new Product();
		product.setNameOfProduct("Котлеты");
		TypeProduct typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Мясные полуфабрикаты");
		//product.setTypeProduct(typeproduct);
		product.setMass(1000.0);
		product.setArticul("676-5675765765");
		product.setDescription("Мясные котлеты");
		ProductEJB productejb=(ProductEJB)ctx.lookup("java:global/classes/ProductEJB!ru.projects.Shop.ejb.ProductEJB");
		productejb.createProduct(product);
		assertEquals(1, productejb.findAllProduct().size());
		Product controlproduct=productejb.findProductById(1L);
		controlproduct.setNameOfProduct("Котлеты куриные");
		productejb.updateProduct(controlproduct);
		Product updated=productejb.findProductById(1L);
		assertEquals("Котлеты куриные", updated.getNameOfProduct());
		productejb.deleteProduct(updated);
		assertEquals(0, productejb.findAllProduct().size());
	}

}
