package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.CityEJB;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.entity.TypeShop;

public class CityTest extends ParentTest {
	
	@Test
	public void shouldCity() throws Exception {
		City city=new City();
		city.setCity("Кизел");
		List<Shop> shoplist=new ArrayList<Shop>();
		Shop shop1=new Shop();
		TypeShop typeshop1=new TypeShop();
		typeshop1.setTypeShop("Гипермаркет");
		shop1.setTypeShop(typeshop1);
		Country country=new Country();
		country.setCountry("Россия");
		shop1.setCountry(country);
		Region region=new Region();
		region.setRegion("Пермский край");
		shop1.setRegion(region);
		shop1.setCity(city);
		shop1.setAdress("Энгельса 86");
		shop1.setEmail("shop@mail.ru");
		shop1.setPhone("8954545343");
		Shop shop2=new Shop();
		TypeShop typeshop2=new TypeShop();
		typeshop2.setTypeShop("Супермаркет");
		shop2.setTypeShop(typeshop2);
		shop2.setCountry(country);
		shop2.setRegion(region);
		shop2.setCity(city);
		shop2.setAdress("Советская 23");
		shop2.setEmail("shop@mail.ru");
		shop2.setPhone("78454654533");
		shoplist.add(shop1);
		shoplist.add(shop2);
		city.setShopList(shoplist);
		CityEJB cityejb=(CityEJB)ctx.lookup("java:global/classes/CityEJB!ru.projects.Shop.ejb.CityEJB");
		cityejb.createCity(city);
		assertEquals(1, cityejb.findAllCity().size());
		City controlcity=cityejb.findCityById(1L);
		assertEquals("Кизел", controlcity.getCity());
		controlcity.setCity("Губаха");
		cityejb.updateCity(controlcity);
		City updated=cityejb.findCityById(1L);
		assertEquals("Губаха", updated.getCity());
		cityejb.deleteCity(updated);
		assertEquals(0, cityejb.findAllCity().size());
	}

}
