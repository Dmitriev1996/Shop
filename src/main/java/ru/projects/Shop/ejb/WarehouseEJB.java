package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Warehouse;
import ru.projects.Shop.interfaces.local.WarehouseLocal;

@Stateless
@Local(WarehouseLocal.class)
@LocalBean
public class WarehouseEJB implements WarehouseLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Warehouse> findAllWarehouse() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllWarehouse", Warehouse.class).getResultList();
	}

	@Override
	public Warehouse findWarehouseById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Warehouse.class, id);
	}

	@Override
	public Warehouse createWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		em.persist(warehouse);
		return warehouse;
	}

	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return em.merge(warehouse);
	}

	@Override
	public void deleteWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		em.remove(em.merge(warehouse));
	}

}
