package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.TransportationType;

public interface TransportationTypeI {
	List<TransportationType> findAllTransportationType();
	TransportationType findTransportationTypeById(Long id);
	TransportationType createTransportationType(TransportationType transportype);
	TransportationType updateTransportationType(TransportationType transtype);
	TransportationType deleteTransportationType(Long id);

}
