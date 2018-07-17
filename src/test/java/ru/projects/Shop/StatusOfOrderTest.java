package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.StatusOfOrderEJB;
import ru.projects.Shop.entity.StatusOfOrder;

public class StatusOfOrderTest extends ParentTest {
	
	@Test
	public void shouldStatusOfOrder() throws Exception {
		StatusOfOrder status=new StatusOfOrder();
		status.setStatus("Заказ в обработке");
		StatusOfOrderEJB statusejb=(StatusOfOrderEJB)ctx.lookup("java:global/classes/StatusOfOrderEJB!ru.projects.Shop.ejb.StatusOfOrderEJB");
		statusejb.createStatusOfOrder(status);
		assertEquals(1, statusejb.findAllStatusOfOrder().size());
		StatusOfOrder controlstatus=statusejb.findStatusOfOrderById(1L);
		controlstatus.setStatus("Заказ отменён");
		statusejb.updateStatusOfOrder(controlstatus);
		StatusOfOrder updated=statusejb.findStatusOfOrderById(1L);
		assertEquals("Заказ отменён", updated.getStatus());
		statusejb.deleteStatusOfOrder(updated);
		assertEquals(0, statusejb.findAllStatusOfOrder().size());
	}

}
