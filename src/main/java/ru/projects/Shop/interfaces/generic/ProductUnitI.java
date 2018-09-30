package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.ProductUnit;

public interface ProductUnitI {
	List<ProductUnit> findAllProductUnits();
	ProductUnit findProductUnitById(Long id);
	ProductUnit createProductUnit(ProductUnit productUnit);
	ProductUnit updateProductUnit(ProductUnit productUnit);
	void deleteProductUnit(ProductUnit productUnit);

}
