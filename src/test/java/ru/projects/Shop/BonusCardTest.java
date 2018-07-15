package ru.projects.Shop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import javax.inject.Inject;

import org.junit.Test;

import ru.projects.Shop.ejb.BonusCardEJB;
import ru.projects.Shop.entity.BonusCard;
import ru.projects.Shop.entity.Client;
import ru.projects.Shop.entity.Sex;

public class BonusCardTest extends ParentTest {
	
	@Test
	public void shouldBonusCard() throws Exception {
		BonusCard bonuscard=new BonusCard();
		Client client=new Client();
		client.setSurname("Дмитриев");
		client.setName("Александр");
		client.setPatronymic("Андреевич");
		Date date=new Date(16, 02, 1996);
		client.setDateOfBirth(date);
		Sex sex=new Sex();
		sex.setSex("Мужской");
		client.setSex(sex);
		bonuscard.setClient(client);
		bonuscard.setSumOfBonus(20);
		BonusCardEJB bonuscardejb=(BonusCardEJB)ctx.lookup("java:global/classes/BonusCardEJB!ru.projects.Shop.ejb.BonusCardEJB");
		bonuscardejb.createBonusCard(bonuscard);
		assertEquals(1, bonuscardejb.findAllBonusCard().size());
		BonusCard bonuscontrol=bonuscardejb.findBonusCardById(1L);
		bonuscontrol.setSumOfBonus(50.0);
		bonuscardejb.updateBonusCard(bonuscontrol);
		BonusCard updated=bonuscardejb.findBonusCardById(1L);
		assertEquals(50.0, updated.getSumOfBonus(), 0.1);
		bonuscardejb.deleteBonusCard(updated);
		assertEquals(0, bonuscardejb.findAllBonusCard().size());
	}

}
