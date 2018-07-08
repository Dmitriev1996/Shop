package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Shop;

public interface ShopI {
	List<Shop> findAllShop();
	Shop findShopById(Long id);
	Shop createShop(Shop shop);
	Shop updateShop(Shop shop);
	Shop deleteShop(Long id);

}
