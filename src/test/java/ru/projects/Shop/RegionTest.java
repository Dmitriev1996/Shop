package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.RegionEJB;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Region;

public class RegionTest extends ParentTest {
	
	@Test
	public void shouldRegion() throws Exception {
		Region region=new Region();
		region.setRegion("Пермский край");
		Country country=new Country();
		country.setCountry("Россия");
		region.setCountry(country);
		RegionEJB regionejb=(RegionEJB)ctx.lookup("java:global/classes/RegionEJB!ru.projects.Shop.ejb.RegionEJB");
		regionejb.createRegion(region);
		assertEquals(1, regionejb.findAllRegion().size());
		Region controlregion=regionejb.findRegionById(1L);
		controlregion.setRegion("Свердловская область");
		regionejb.updateRegion(controlregion);
		Region updated=regionejb.findRegionById(1L);
		assertEquals("Свердловская область", updated.getRegion());
		regionejb.deleteRegion(updated);
		assertEquals(0, regionejb.findAllRegion().size());
	}

}
