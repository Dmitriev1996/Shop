package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Warehouse;

public interface WarehouseI {
	List<Warehouse> findAllWarehouse();
	Warehouse findWarehouseById(Long id);
	Warehouse createWarehouse(Warehouse warehouse);
	Warehouse updateWarehouse(Warehouse warehouse);
	Warehouse deleteWarehouse(Long id);

}
