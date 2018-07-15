package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Order;

public interface OrderI {
	List<Order> findAllOrder();
	Order findOrderById(Long id);
	Order createOrder(Order order);
	Order updateOrder(Order order);
	void deleteOrder(Order order);

}
