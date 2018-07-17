package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.TransportationTypeEJB;
import ru.projects.Shop.entity.TransportationType;

public class TransportationTypeTest extends ParentTest {
	
	@Test
	public void shouldTransportationType() throws Exception {
		TransportationType transtype=new TransportationType();
		transtype.setTransportationType("Курьер");
		TransportationTypeEJB typeejb=(TransportationTypeEJB)ctx.lookup("java:global/classes/TransportationTypeEJB!ru.projects.Shop.ejb.TransportationTypeEJB");
		typeejb.createTransportationType(transtype);
		assertEquals(1, typeejb.findAllTransportationType().size());
		TransportationType controltype=typeejb.findTransportationTypeById(1L);
		controltype.setTransportationType("Почта");
		typeejb.updateTransportationType(controltype);
		TransportationType updated=typeejb.findTransportationTypeById(1L);
		assertEquals("Почта", updated.getTransportationType());
		typeejb.deleteTransportationType(updated);
		assertEquals(0, typeejb.findAllTransportationType().size());
	}

}
