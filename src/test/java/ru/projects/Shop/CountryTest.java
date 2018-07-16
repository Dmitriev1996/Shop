package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.CountryEJB;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;

public class CountryTest extends ParentTest {
	
	@Test
	public void shouldCountry() throws Exception {
		Country country=new Country();
		country.setCountry("Россия");
		Region region=new Region();
		region.setRegion("Пермский край");
		List<City> citylist=new ArrayList<City>();
		City city;
		city=new City();
		city.setCity("Кизел");
		citylist.add(city);
		city=new City();
		city.setCity("Александровск");
		citylist.add(city);
		city=new City();
		city.setCity("Губаха");
		citylist.add(city);
		region.setCityList(citylist);
		List<Region> regionlist=new ArrayList<Region>();
		regionlist.add(region);
		country.setRegionList(regionlist);
		CountryEJB countryejb=(CountryEJB)ctx.lookup("java:global/classes/CountryEJB!ru.projects.Shop.ejb.CountryEJB");
		countryejb.createCountry(country);
		assertEquals(1, countryejb.findAllCountry().size());
		Country controlcountry=countryejb.findCountryById(1L);
		controlcountry.setCountry("США");
		countryejb.updateCountry(controlcountry);
		Country updated=countryejb.findCountryById(1L);
		assertEquals("США", updated.getCountry());
		countryejb.deleteCountry(updated);
		assertEquals(0, countryejb.findAllCountry().size());
	}

}
