package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Transportation;

public interface TransportationI {
	List<Transportation> findAllTransportation();
	Transportation findTransportationById(Long id);
	Transportation createTransportation(Transportation transportation);
	Transportation updateTransportation(Transportation transportation);
	void deleteTransportation(Transportation transportation);

}
