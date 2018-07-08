package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Country;

public interface CountryI {
	List<Country> findAllCountry();
	Country findCountryById(Long id);
	Country createCountry(Country country);
	Country updateCountry(Country country);
	Country deleteCountry(Long id);

}
