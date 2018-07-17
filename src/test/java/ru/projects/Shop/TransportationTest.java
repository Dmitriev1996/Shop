package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.TransportationEJB;
import ru.projects.Shop.entity.Adress;
import ru.projects.Shop.entity.City;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Country;
import ru.projects.Shop.entity.Order;
import ru.projects.Shop.entity.Region;
import ru.projects.Shop.entity.Sex;
import ru.projects.Shop.entity.StatusOfOrder;
import ru.projects.Shop.entity.Transportation;
import ru.projects.Shop.entity.TransportationType;

public class TransportationTest extends ParentTest {
	
	@Test
	public void shouldTransportation() throws Exception {
		Transportation transportation=new Transportation();
		Adress adress=new Adress();
	    City city=new City();
	    city.setCity("Кизел");
	    adress.setCity(city);
	    Country country=new Country();
	    country.setCountry("Россия");
	    adress.setCountry(country);
	    Region region=new Region();
	    region.setRegion("Пермский край");
	    adress.setRegion(region);
	    adress.setStreet("Ленина");
	    adress.setNumberOfHouse(62);
	    adress.setCorpus("A");
	    adress.setNumberOfEntrance(1);
	    adress.setNumberOfAppartament(5L);
	    transportation.setAdress(adress);
	    TransportationType transtype=new TransportationType();
	    transtype.setTransportationType("Курьер");
	    transportation.setTransportationType(transtype);
	    Order order=new Order();
	    Client client=new Client();
	    client.setSurname("Дмитриев");
	    client.setName("Александр");
	    client.setPatronymic("Андреевич");
	    Sex sex=new Sex();
	    sex.setSex("Мужской");
	    client.setSex(sex);
	    order.setClient(client);
	    StatusOfOrder status=new StatusOfOrder();
	    status.setStatus("Заказ принят");
	    order.setStatusOfOrder(status);
	    transportation.setOrder(order);
	    TransportationEJB transejb=(TransportationEJB)ctx.lookup("java:global/classes/TransportationEJB!ru.projects.Shop.ejb.TransportationEJB");
	    transejb.createTransportation(transportation);
	    assertEquals(1, transejb.findAllTransportation().size());
	    Transportation controltransportation=transejb.findTransportationById(1L);
	    controltransportation.getAdress().getCity().setCity("Губаха");
	    transejb.updateTransportation(controltransportation);
	    Transportation updated=transejb.findTransportationById(1L);
	    assertEquals("Губаха", updated.getAdress().getCity().getCity());
	    transejb.deleteTransportation(updated);
	    assertEquals(0, transejb.findAllTransportation().size());
	}

}
