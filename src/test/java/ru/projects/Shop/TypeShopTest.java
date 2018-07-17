package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.TypeShopEJB;
import ru.projects.Shop.entity.TypeShop;

public class TypeShopTest extends ParentTest {
	
	@Test
	public void shouldTypeShop() throws Exception {
		TypeShop typeshop=new TypeShop();
		typeshop.setTypeShop("Гипермаркет");
		TypeShopEJB typeejb=(TypeShopEJB)ctx.lookup("java:global/classes/TypeShopEJB!ru.projects.Shop.ejb.TypeShopEJB");
		typeejb.createTypeShop(typeshop);
		assertEquals(1, typeejb.findAllTypeShop().size());
		TypeShop controltypeshop=typeejb.findTypeShopById(1L);
		controltypeshop.setTypeShop("Супермаркет");
		typeejb.updateTypeShop(controltypeshop);
		TypeShop updated=typeejb.findTypeShopById(1L);
		assertEquals("Супермаркет", updated.getTypeShop());
		typeejb.deleteTypeShop(updated);
		assertEquals(0, typeejb.findAllTypeShop().size());
	}

}
