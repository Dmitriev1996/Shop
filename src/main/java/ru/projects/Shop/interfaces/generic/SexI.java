package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Sex;

public interface SexI {
	List<Sex> findAllSex();
	Sex findSexById(Long id);
	Sex createSex(Sex sex);
	Sex updateSex(Sex sex);
	Sex deleteSex(Long id);

}
