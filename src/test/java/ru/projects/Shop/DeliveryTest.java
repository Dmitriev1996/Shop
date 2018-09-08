package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.DeliveryEJB;
import ru.projects.Shop.entity.Delivery;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Provider;
import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.entity.TypeProduct;
import ru.projects.Shop.entity.TypeShop;

public class DeliveryTest extends ParentTest {
	
	@Test
	public void shouldDelivery() throws Exception {
		Delivery delivery=new Delivery();
		delivery.setDateOfDelivery(new Date(17, 07, 2018));
		List<Product> productlist=new ArrayList<Product>();
		Product product;
		product=new Product();
		product.setNameOfProduct("Пельмени");
		TypeProduct typeproduct;
		typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Мясные полуфабрикаты");
		//product.setTypeProduct(typeproduct);
		productlist.add(product);
		product=new Product();
		product.setNameOfProduct("Котлеты");
		//product.setTypeProduct(typeproduct);
		productlist.add(product);
		Provider provider=new Provider();
		provider.setNameOfProvider("Тандер");
		delivery.setProvider(provider);
		Shop shop=new Shop();
		TypeShop typeshop=new TypeShop();
		typeshop.setTypeShop("Гипермаркет");
		shop.setTypeShop(typeshop);
		delivery.setShop(shop);
		DeliveryEJB deliveryejb=(DeliveryEJB)ctx.lookup("java:global/classes/DeliveryEJB!ru.projects.Shop.ejb.DeliveryEJB");
		deliveryejb.createDelivery(delivery);
		assertEquals(1, deliveryejb.findAllDelivery().size());
		Delivery controldelivery=deliveryejb.findDeliveryById(1L);
		controldelivery.getProvider().setNameOfProvider("Китай");
		deliveryejb.updateDelivery(controldelivery);
		Delivery updated=deliveryejb.findDeliveryById(1L);
		assertEquals("Китай", updated.getProvider().getNameOfProvider());
		deliveryejb.deleteDelivery(updated);
		assertEquals(0, deliveryejb.findAllDelivery().size());
	}

}
