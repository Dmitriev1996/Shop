package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.BuyEJB;
import ru.projects.Shop.entity.Buy;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.TypeProduct;

public class BuyTest extends ParentTest {
	
	@Test
	public void shouldBuy() throws Exception {
		Buy buy=new Buy();
		buy.setDateBuy(new Date(15, 07, 2018));
		List<Product> productlist=new ArrayList<Product>();
		Product product1=new Product();
		product1.setNameOfProduct("Хлеб 'Финский'");
		TypeProduct typeproduct1=new TypeProduct();
		typeproduct1.setTypeProduct("Хлебобулочные изделия");
		product1.setTypeProduct(typeproduct1);
		product1.setMass(300.0);
		product1.setPrice(30.0);
		product1.setArticul("3443-565656");
		product1.setDescription("Цельнозерновой ржаной хлеб");
		Product product2=new Product();
		product2.setNameOfProduct("Пельмени 'Фроловские'");
		TypeProduct typeproduct2=new TypeProduct();
		typeproduct2.setTypeProduct("Замороженные полуфабрикаты");
		product2.setTypeProduct(typeproduct2);
		product2.setMass(800.0);
		product2.setPrice(250.0);
		product2.setArticul("3421-546576");
		product2.setDescription("Мясные пельмени");
		productlist.add(product1);
		productlist.add(product2);
		buy.setProductList(productlist);
		buy.setSumBuy(product1.getPrice()+product2.getPrice());
		BuyEJB buyejb=(BuyEJB)ctx.lookup("java:global/classes/BuyEJB!ru.projects.Shop.ejb.BuyEJB");
		buyejb.createBuy(buy);
		assertEquals(1, buyejb.findAllBuy().size());
		Buy controlbuy=buyejb.findBuyById(1L);
		controlbuy.setSumBuy(500.0);
		buyejb.updateBuy(controlbuy);
		Buy updated=buyejb.findBuyById(1L);
		assertEquals(500.0, updated.getSumBuy(), 0.1);
		buyejb.deleteBuy(updated);
		assertEquals(0, buyejb.findAllBuy().size());
	}

}
