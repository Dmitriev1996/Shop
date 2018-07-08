package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.TypeShop;

public interface TypeShopI {
	List<TypeShop> findAllTypeShop();
	TypeShop findTypeShopById(Long id);
	TypeShop createTypeShop(TypeShop typeshop);
	TypeShop updateTypeShop(TypeShop typeshop);
	TypeShop deleteTypeShop(Long id);

}
