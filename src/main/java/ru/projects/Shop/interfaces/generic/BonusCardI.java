package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.BonusCard;

public interface BonusCardI {
	List<BonusCard> findAllBonusCard();
	BonusCard findBonusCardById(Long id);
	BonusCard createBonusCard(BonusCard bonuscard);
	BonusCard updateBonusCard(BonusCard bonuscard);
	BonusCard deleteBonusCard(Long id);

}
