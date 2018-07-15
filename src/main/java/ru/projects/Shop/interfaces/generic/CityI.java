package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.City;

public interface CityI {
	List<City> findAllCity();
	City findCityById(Long id);
	City createCity(City city);
	City updateCity(City city);
	void deleteCity(City city);

}
