package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Order;
import ru.projects.Shop.interfaces.local.OrderLocal;

@Stateless
@Local(OrderLocal.class)
@LocalBean
public class OrderEJB implements OrderLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllOrder", Order.class).getResultList();
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Order.class, id);
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		em.persist(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return em.merge(order);
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		em.remove(em.merge(order));
	}

}
