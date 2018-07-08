package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Adress;

public interface AdressI {
	List<Adress> findAllAdress();
	Adress findAdressById(Long id);
	Adress createAdress(Adress adress);
	Adress updateAdress(Adress adress);
	Adress deleteAdress(Long id);

}
