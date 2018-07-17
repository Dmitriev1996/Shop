package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.ShopEJB;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.entity.TypeShop;

public class ShopTest extends ParentTest {
	
	@Test
	public void shouldShop() throws Exception {
		Shop shop=new Shop();
		City city=new City();
		city.setCity("Кизел");
		shop.setCity(city);
		Region region=new Region();
		region.setRegion("Пермский край");
		shop.setRegion(region);
		Country country=new Country();
		country.setCountry("Россия");
		shop.setCountry(country);
		shop.setAdress("Ленина 62а");
		TypeShop typeshop=new TypeShop();
		typeshop.setTypeShop("Гипермаркет");
		shop.setTypeShop(typeshop);
		ShopEJB shopejb=(ShopEJB)ctx.lookup("java:global/classes/ShopEJB!ru.projects.Shop.ejb.ShopEJB");
		shopejb.createShop(shop);
		assertEquals(1, shopejb.findAllShop().size());
		Shop controlshop=shopejb.findShopById(1L);
		controlshop.setAdress("Ленина 62");
		shopejb.updateShop(controlshop);
		Shop updated=shopejb.findShopById(1L);
		assertEquals("Ленина 62", updated.getAdress());
		shopejb.deleteShop(updated);
		assertEquals(0, shopejb.findAllShop().size());
	}

}
