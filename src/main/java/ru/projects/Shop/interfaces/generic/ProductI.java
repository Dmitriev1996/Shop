package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Product;

public interface ProductI {
	List<Product> findAllProduct();
	Product findProductById(Long id);
	Product createProduct(Product product);
	Product updateProduct(Product product);
	void deleteProduct(Product product);

}
