package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Delivery;

public interface DeliveryI {
	List<Delivery> findAllDelivery();
	Delivery findDeliveryById(Long id);
	Delivery createDelivery(Delivery delivery);
	Delivery updateDelivery(Delivery delivery);
	Delivery deleteDelivery(Long id);

}
