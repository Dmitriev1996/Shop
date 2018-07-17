package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.TypeProductEJB;
import ru.projects.Shop.entity.TypeProduct;

public class TypeProductTest extends ParentTest {
	
	@Test
	public void shouldTypeProduct() throws Exception {
		TypeProduct typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Фрукты");
		TypeProductEJB typeejb=(TypeProductEJB)ctx.lookup("java:global/classes/TypeProductEJB!ru.projects.Shop.ejb.TypeProductEJB");
		typeejb.createTypeProduct(typeproduct);
		assertEquals(1, typeejb.findAllTypeProduct().size());
		TypeProduct controltypeproduct=typeejb.findTypeProductById(1L);
		controltypeproduct.setTypeProduct("Овощи");
		typeejb.updateTypeProduct(controltypeproduct);
		TypeProduct updated=typeejb.findTypeProductById(1L);
		assertEquals("Овощи", updated.getTypeProduct());
		typeejb.deleteTypeProduct(updated);
		assertEquals(0, typeejb.findAllTypeProduct().size());
	}

}
