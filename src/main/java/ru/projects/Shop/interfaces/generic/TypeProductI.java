package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.TypeProduct;

public interface TypeProductI {
	List<TypeProduct> findAllTypeProduct();
	TypeProduct findTypeProductById(Long id);
	TypeProduct createTypeProduct(TypeProduct typeproduct);
	TypeProduct updateTypeProduct(TypeProduct typeproduct);
	void deleteTypeProduct(TypeProduct typeproduct);

}
