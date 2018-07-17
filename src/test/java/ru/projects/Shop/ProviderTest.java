package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.ProviderEJB;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Provider;

public class ProviderTest extends ParentTest {
	
	@Test
	public void shouldProvider() throws Exception {
		Provider provider=new Provider();
		provider.setAdress("Ленина 62 а");
		City city=new City();
		city.setCity("Кизел");
		provider.setCity(city);
		Country country=new Country();
		country.setCountry("Россия");
		provider.setCountry(country);
		provider.setNameOfProvider("Тандер");
		ProviderEJB providerejb=(ProviderEJB)ctx.lookup("java:global/classes/ProviderEJB!ru.projects.Shop.ejb.ProviderEJB");
		providerejb.createProvider(provider);
		assertEquals(1, providerejb.findAllProvider().size());
		Provider controlprovider=providerejb.findProviderById(1L);
		controlprovider.setNameOfProvider("Products");
		providerejb.updateProvider(controlprovider);
		Provider updated=providerejb.findProviderById(1L);
		assertEquals("Products", updated.getNameOfProvider());
		providerejb.deleteProvider(updated);
		assertEquals(0, providerejb.findAllProvider().size());
	}

}
