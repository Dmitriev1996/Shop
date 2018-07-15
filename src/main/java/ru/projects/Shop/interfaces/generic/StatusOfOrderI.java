package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.StatusOfOrder;

public interface StatusOfOrderI {
	List<StatusOfOrder> findAllStatusOfOrder();
	StatusOfOrder findStatusOfOrderById(Long id);
	StatusOfOrder createStatusOfOrder(StatusOfOrder status);
	StatusOfOrder updateStatusOfOrder(StatusOfOrder status);
	void deleteStatusOfOrder(StatusOfOrder status);

}
