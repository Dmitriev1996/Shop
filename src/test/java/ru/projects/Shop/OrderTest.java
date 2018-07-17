package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ru.projects.Shop.ejb.OrderEJB;
import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Order;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.entity.StatusOfOrder;
import ru.projects.Shop.entity.Transportation;
import ru.projects.Shop.entity.TransportationType;
import ru.projects.Shop.entity.TypeProduct;

public class OrderTest extends ParentTest {
	
	@Test
	public void shouldOrder() throws Exception {
		Order order=new Order();
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		order.setClient(client);
		List<Product> productlist=new ArrayList<Product>();
		Product product;
		product=new Product();
		product.setNameOfProduct("Молоко");
		TypeProduct typeproduct;
		typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Молочные продукты");
		product.setTypeProduct(typeproduct);
		productlist.add(product);
		product=new Product();
		product.setNameOfProduct("Хлеб");
		typeproduct=new TypeProduct();
		typeproduct.setTypeProduct("Хлебобулочные изделия");
		product.setTypeProduct(typeproduct);
		productlist.add(product);
		order.setDateOfOrder(new Date(17, 07, 2018));
		StatusOfOrder status=new StatusOfOrder();
		status.setStatus("В обработке");
		order.setStatusOfOrder(status);
		order.setProductList(productlist);
		order.setSumOfOrder(100.0);
		Transportation transportation=new Transportation();
		Adress adress=new Adress();
		City city=new City();
		city.setCity("Кизел");
		Country country=new Country();
		country.setCountry("Россия");
		adress.setCountry(country);
		adress.setCity(city);
		adress.setStreet("Ленина");
		adress.setNumberOfHouse(62);
		adress.setCorpus("A");
		adress.setNumberOfEntrance(1);
		adress.setNumberOfAppartament(5L);
		transportation.setAdress(adress);
		TransportationType type=new TransportationType();
		type.setTransportationType("Курьером");
		transportation.setTransportationType(type);
		order.setTransportation(transportation);
		OrderEJB orderejb=(OrderEJB)ctx.lookup("java:global/classes/OrderEJB!ru.projects.Shop.ejb.OrderEJB");
		orderejb.createOrder(order);
		assertEquals(1, orderejb.findAllOrder().size());
		Order controlorder=orderejb.findOrderById(1L);
		controlorder.setSumOfOrder(500.0);
		orderejb.updateOrder(controlorder);
		Order updated=orderejb.findOrderById(1L);
		assertEquals(500.0, updated.getSumOfOrder(), 0.1);
		orderejb.deleteOrder(updated);
		assertEquals(0, orderejb.findAllOrder().size());
	}

}
