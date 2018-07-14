package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.AdressEJB;
import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;

public class AdressTest extends ParentTest {
	
	@Test
	public void shouldAdress() throws Exception {
		Adress adress=new Adress();
		Country country=new Country();
		country.setCountry("Россия");
		adress.setCountry(country);
		Region region=new Region();
		region.setRegion("Пермский край");
		adress.setRegion(region);
		City city=new City();
		city.setCity("Кизел");
		adress.setCity(city);
		adress.setStreet("Ленина");
		adress.setNumberOfHouse(62);
		adress.setCorpus("A");
		adress.setNumberOfEntrance(1);
		adress.setNumberOfAppartament((long)5);
		AdressEJB adressejb=(AdressEJB)ctx.lookup("java:global/classes/AdressEJB!ru.projects.Shop.ejb.AdressEJB");
		adressejb.createAdress(adress);
		assertEquals(1, adressejb.findAllAdress().size());
		Adress controladress=adressejb.findAdressById(1L);
		assertEquals("Россия", controladress.getCountry().getCountry());
		country.setCountry("США");
		controladress.setCountry(country);
	    adressejb.updateAdress(controladress);
	    Adress updated=adressejb.findAdressById(1L);
	    assertEquals("США", updated.getCountry().getCountry());
	    adressejb.deleteAdress(updated);
	    assertEquals(0, adressejb.findAllAdress().size());
	}

}
