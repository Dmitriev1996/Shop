package ru.projects.Shop.listener;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.PostPersist;

import ru.projects.Shop.ejb.WarehouseEJB;
import ru.projects.Shop.entity.Delivery;
import ru.projects.Shop.entity.Product;
import ru.projects.Shop.entity.ProductImport;
import ru.projects.Shop.entity.ProductUnit;
import ru.projects.Shop.entity.Warehouse;

public class ProductUnitCreater {
	private ArrayList<ProductImport> productImportList;
	private ArrayList<ProductUnit> productUnitList;
	private ProductUnit productUnit;
	
	@Inject
	private WarehouseEJB warehouseEJB;
	
	@PostPersist
	public void updateProductUnit(Delivery delivery) {
		Warehouse warehouse=delivery.getWarehouse();
		productImportList=
				(ArrayList<ProductImport>) delivery.getProductImportList();
		productUnitList=
				(ArrayList<ProductUnit>) warehouse.getProductUnitList();
		for(ProductImport productImport : productImportList) {
			for(ProductUnit productUnit : productUnitList) {
				Product product1=productImport.getProduct();
				Product product2=productUnit.getProduct();
				if(product1.getProduct_ID()==product2.getProduct_ID()) {
					productUnit.setValue(productUnit.getValue()+productImport.getValue());
					break;
				}
			}
		}
		warehouse.setProductUnitList(productUnitList);
		warehouseEJB.updateWarehouse(warehouse);
	}

}
