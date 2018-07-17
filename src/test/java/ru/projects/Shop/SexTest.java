package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.projects.Shop.ejb.SexEJB;
import ru.projects.Shop.entity.Sex;

public class SexTest extends ParentTest {
	
	@Test
	public void shouldSex() throws Exception {
		Sex sex=new Sex();
		sex.setSex("Мужской");
		SexEJB sexejb=(SexEJB)ctx.lookup("java:global/classes/SexEJB!ru.projects.Shop.ejb.SexEJB");
		sexejb.createSex(sex);
		assertEquals(1, sexejb.findAllSex().size());
		Sex controlsex=sexejb.findSexById(1L);
		controlsex.setSex("Женский");
		sexejb.updateSex(controlsex);
		Sex updated=sexejb.findSexById(1L);
		assertEquals("Женский", updated.getSex());
		sexejb.deleteSex(updated);
		assertEquals(0, sexejb.findAllSex().size());
	}

}
