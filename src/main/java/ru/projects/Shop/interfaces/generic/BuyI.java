package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Buy;

public interface BuyI {
	List<Buy> findAllBuy();
	Buy findBuyById(Long id);
	Buy createBuy(Buy buy);
	Buy updateBuy(Buy buy);
	void deleteBuy(Buy buy);

}
