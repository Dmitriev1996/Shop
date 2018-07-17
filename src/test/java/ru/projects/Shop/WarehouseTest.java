package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.WarehouseEJB;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.Shop;
import ru.projects.Shop.entity.TypeProduct;
import ru.projects.Shop.entity.TypeShop;
import ru.projects.Shop.entity.Warehouse;

public class WarehouseTest extends ParentTest {
	
	@Test
	public void shouldWarehouse() throws Exception {
		Warehouse warehouse=new Warehouse();
		Product product=new Product();
		product.setNameOfProduct("Апельсины");
		TypeProduct typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Фрукты");
		product.setTypeProduct(typeproduct);
		warehouse.setProduct(product);
		Shop shop=new Shop();
		shop.setAdress("Ленина 62");
		Country country=new Country();
		country.setCountry("Россия");
		Region region=new Region();
		region.setRegion("Пермский край");
		City city=new City();
		city.setCity("Кизел");
		shop.setCountry(country);
		shop.setRegion(region);
		shop.setCity(city);
		TypeShop typeshop=new TypeShop();
		typeshop.setTypeShop("Гипермаркет");
		shop.setTypeShop(typeshop);
		warehouse.setShop(shop);
		warehouse.setValue(5L);
		WarehouseEJB warehouseejb=(WarehouseEJB)ctx.lookup("java:global/classes/WarehouseEJB!ru.projects.Shop.ejb.WarehouseEJB");
		warehouseejb.createWarehouse(warehouse);
		assertEquals(1, warehouseejb.findAllWarehouse().size());
		Warehouse controlwarehouse=warehouseejb.findWarehouseById(1L);
		controlwarehouse.setValue(10L);
		warehouseejb.updateWarehouse(controlwarehouse);
		Warehouse updated=warehouseejb.findWarehouseById(1L);
		assertEquals(10L, (long)updated.getValue());
		warehouseejb.deleteWarehouse(updated);
		assertEquals(0, warehouseejb.findAllWarehouse().size());
	}

}
